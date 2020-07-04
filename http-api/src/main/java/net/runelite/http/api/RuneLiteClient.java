package net.runelite.http.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.QueryStringEncoder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientResponse;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;

/**
 * Base client for RuneLite API, capable of synchronous and asynchronous network calls.
 * Incorporates an exponential backoff strategy with jitter.
 */
@Slf4j
public class RuneLiteClient
{
	private final HttpClient client;
	private final String endpoint;
	private final RetryBackoffSpec retryStrategy;

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final RetryBackoffSpec DEFAULT_RETRY_STRATEGY = Retry.backoff(5, Duration.ofSeconds(2))
		.onRetryExhaustedThrow((retry, signal) -> new IOException(signal.failure()));

	protected RuneLiteClient(HttpClient client, String endpoint)
	{
		this(client, endpoint, DEFAULT_RETRY_STRATEGY);
	}

	protected RuneLiteClient(HttpClient client, String endpoint, RetryBackoffSpec retryStrategy)
	{
		this.endpoint = endpoint;
		this.client = client
			.doOnRequest((req, con) -> log.debug(String.format("Built URL: %S", req.fullPath())))
			.doOnRequestError((req, e) -> log.warn(String.format("API request error: %s", e.getMessage())))
			.doOnResponseError((req, e) -> log.warn(String.format("API response error: %s", e.getMessage())));
		this.retryStrategy = retryStrategy.onRetryExhaustedThrow((retry, signal) -> new IOException(signal.failure()));
	}

	protected <T> RequestBuilder<T> get(Class<T> clazz)
	{
		return new RequestBuilder<>(endpoint, uri -> request(client.get(), uri, clazz));
	}

	protected <T> RequestBuilder<T> post(Class<T> clazz)
	{
		return new RequestBuilder<>(endpoint, uri -> request(client.post(), uri, clazz));
	}

	private <T> Mono<T> request(HttpClient.ResponseReceiver<?> receiver, URI uri, Class<T> clazz)
	{
		return receiver.uri(uri.toString())
			.responseSingle(RuneLiteClient::processResponse)
			.retryWhen(retryStrategy.doBeforeRetry(signal -> log.debug("Retrying")))
			.flatMap(bytes -> toMono(bytes, clazz));
	}

	protected static <T> Mono<T> toMono(byte[] bytes, Class<T> clazz)
	{
		System.out.println(Arrays.toString(bytes));
		return Mono.fromCallable(() -> OBJECT_MAPPER.readValue(bytes, clazz));
	}

	private static Mono<byte[]> processResponse(HttpClientResponse response, ByteBufMono bytes)
	{
		if (response.status() != HttpResponseStatus.OK)
		{
			return Mono.error(new IOException(response.status().reasonPhrase()));
		}
		return bytes.asByteArray();
	}

	public long getRetryMaxAttempts()
	{
		return DEFAULT_RETRY_STRATEGY.maxAttempts;
	}

	public Duration getRetryMinBackoff()
	{
		return DEFAULT_RETRY_STRATEGY.minBackoff;
	}

	public double getRetryJitterFactor()
	{
		return DEFAULT_RETRY_STRATEGY.jitterFactor;
	}

	protected static class RequestBuilder<T>
	{

		private QueryStringEncoder query;
		private final Function<URI, Mono<T>> executor;

		public RequestBuilder(String endpoint, Function<URI, Mono<T>> executor)
		{
			this.query = new QueryStringEncoder(endpoint);
			this.executor = executor;
		}

		public RequestBuilder<T> queryParam(String field, String value)
		{
			query.addParam(field, value);
			return this;
		}

		public Mono<T> retrieve()
		{
			try
			{
				return executor.apply(query.toUri());
			}
			catch (URISyntaxException e)
			{
				return Mono.error(e);
			}

		}
	}
}
