/*
 * Copyright (c) 2020, Ugnius <https://github.com/UgiR>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.api;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Slf4j
public class RuneLiteApiClient
{
	private final OkHttpClient client;
	private final HttpUrl baseUrl;
	private final String endpoint;

	protected static final HttpUrl API_BASE_URL;
	protected static final HttpUrl STATIC_BASE_URL;
	private static final Gson GSON;

	protected static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");
	protected static final String AUTH_HEADER = "RUNELITE-AUTH";
	protected static final String MACHINEID_HEADER = "RUNELITE-MACHINEID";

	static
	{
		API_BASE_URL = createApiBaseUrl();
		STATIC_BASE_URL = createStaticBaseUrl();
		GSON = new Gson();
	}

	/**
	 * @param clientBuilder A builder for an {@link OkHttpClient}.
	 * @param endpoint      API endpoint to query.
	 */
	public RuneLiteApiClient(OkHttpClient.Builder clientBuilder, String endpoint)
	{
		this(clientBuilder, API_BASE_URL, endpoint);
	}

	/**
	 * @param clientBuilder A builder for an {@link OkHttpClient}.
	 * @param baseUrl       Base URL of API.
	 * @param endpoint      API endpoint to query.
	 */
	public RuneLiteApiClient(OkHttpClient.Builder clientBuilder, HttpUrl baseUrl, String endpoint)
	{
		Objects.requireNonNull(baseUrl, "Base URL must not be null.");
		Objects.requireNonNull(endpoint, "Provided endpoint must not be null.");
		this.client = clientBuilder
			.pingInterval(30, TimeUnit.SECONDS)
			.addInterceptor(new RuneLiteInterceptor())
			.build();
		this.baseUrl = baseUrl;
		this.endpoint = endpoint;
	}

	/**
	 * Synchronously send a GET request.
	 * {@code urlInterceptor} defaults to no-op.
	 *
	 * @see RuneLiteApiClient#get_(Function)
	 */
	protected Response get_() throws IOException
	{
		return get_(Function.identity());
	}

	/**
	 * Synchronously send a GET request with changes to the URL.
	 *
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return The {@link Response} to the request.
	 * @throws IOException if the request is not successful.
	 */
	protected Response get_(Function<HttpUrl, HttpUrl> urlInterceptor) throws IOException
	{
		return request(new Request.Builder().get(), urlInterceptor);
	}

	/**
	 * Asynchronously send a GET request.
	 * {@code urlInterceptor} defaults to no-op.
	 *
	 * @see RuneLiteApiClient#getAsync_(Function)
	 */
	protected CompletableFuture<Response> getAsync_()
	{
		return getAsync_(Function.identity());
	}

	/**
	 * Asynchronously send a GET request with changes to the URL.
	 *
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return A {@link CompletableFuture} containing the {@link Response}. If the request fails,
	 * the future completes exceptionally.
	 */
	protected CompletableFuture<Response> getAsync_(Function<HttpUrl, HttpUrl> urlInterceptor)
	{
		return requestAsync(new Request.Builder().get(), urlInterceptor);
	}

	/**
	 * Synchronously send a POST request with changes to the URL.
	 *
	 * @param body           The {@link RequestBody} to include with the request.
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return The {@link Response} to the request.
	 * @throws IOException if the request is not successful.
	 */
	protected Response post_(RequestBody body, Function<HttpUrl, HttpUrl> urlInterceptor) throws IOException
	{
		return request(new Request.Builder().post(body), urlInterceptor);
	}

	/**
	 * Asynchronously send a POST request.
	 * {@code urlInterceptor} defaults to no-op.
	 *
	 * @see RuneLiteApiClient#postAsync_(RequestBody, Function)
	 */
	protected CompletableFuture<Response> postAsync_(RequestBody body)
	{
		return postAsync_(body, Function.identity());
	}

	/**
	 * Asynchronously send a POST request with changes to the URL.
	 *
	 * @param body           The {@link RequestBody} to include with the request.
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return A {@link CompletableFuture} containing the {@link Response}. If the request fails,
	 * the future completes exceptionally.
	 */
	protected CompletableFuture<Response> postAsync_(RequestBody body, Function<HttpUrl, HttpUrl> urlInterceptor)
	{
		return requestAsync(new Request.Builder().post(body), urlInterceptor);
	}

	/**
	 * Synchronously send a PUT request with changes to the URL.
	 *
	 * @param body           The {@link RequestBody} to include with the request.
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return The {@link Response} to the request.
	 * @throws IOException if the request is not successful.
	 */
	protected Response put_(RequestBody body, Function<HttpUrl, HttpUrl> urlInterceptor) throws IOException
	{
		return request(new Request.Builder().put(body), urlInterceptor);
	}

	/**
	 * Asynchronously send a PUT request with changes to the URL.
	 *
	 * @param body           The {@link RequestBody} to include with the request.
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return A {@link CompletableFuture} containing the {@link Response}. If the request fails,
	 * the future completes exceptionally.
	 */
	protected CompletableFuture<Response> putAsync_(RequestBody body, Function<HttpUrl, HttpUrl> urlInterceptor)
	{
		return requestAsync(new Request.Builder().put(body), urlInterceptor);
	}

	/**
	 * Synchronously send a DELETE request with changes to the URL.
	 *
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return The {@link Response} to the request.
	 * @throws IOException if the request is not successful.
	 */
	protected Response delete_(Function<HttpUrl, HttpUrl> urlInterceptor) throws IOException
	{
		return request(new Request.Builder().delete(), urlInterceptor);
	}

	/**
	 * Asynchronously send a DELETE request with changes to the URL.
	 *
	 * @param urlInterceptor A {@link Function} to mutate the built URL.
	 * @return A {@link CompletableFuture} containing the {@link Response}. If the request fails,
	 * the future completes exceptionally.
	 */
	protected CompletableFuture<Response> deleteAsync_(Function<HttpUrl, HttpUrl> urlInterceptor)
	{
		return requestAsync(new Request.Builder().delete(), urlInterceptor);
	}

	private CompletableFuture<Response> requestAsync(Request.Builder requestBuilder, Function<HttpUrl, HttpUrl> urlInterceptor)
	{
		Request request = requestBuilder
			.url(urlInterceptor.apply(baseUrl.newBuilder()
				.addPathSegments(endpoint)
				.build()))
			.build();

		OkHttpFutureResponse response = new OkHttpFutureResponse();
		Call call = client.newCall(request);
		call.enqueue(response);

		return response.getFuture()
			.whenComplete((r, e) ->
			{
				// Ensure response is closed in case exception
				if (e != null)
				{
					r.body().close();
				}
			});
	}

	private Response request(Request.Builder requestBuilder, Function<HttpUrl, HttpUrl> urlInterceptor) throws IOException
	{
		Request request = requestBuilder
			.url(urlInterceptor.apply(baseUrl.newBuilder()
				.addPathSegments(endpoint)
				.build()))
			.build();

		return client.newCall(request).execute();
	}

	/**
	 * Deserializes the JSON body of a {@link Response} into the provided {@link Type}.
	 * This method will always close the response body to avoid resource leaks.
	 *
	 * @param response The {@link Response} containing the body.
	 * @param type     The {@link Type} to deserialize to.
	 * @return The deserialized object.
	 * @throws IOException if the body cannot be deserialized.
	 */
	protected static <T> T bodyToObject(Response response, Type type) throws IOException
	{
		try
		{
			return GSON.fromJson(response.body().charStream(), type);
		}
		catch (JsonParseException e)
		{
			throw new IOException(e);
		}
		finally
		{
			response.body().close();
		}
	}

	/**
	 * Deserializes the JSON body of a {@link Response} into the provided {@link Type} and
	 * wrap it in a {@link CompletableFuture}.
	 * This method will always close the response body to avoid resource leaks.
	 *
	 * @param response The {@link Response} containing the body.
	 * @param type     The {@link Type} to deserialize to.
	 * @return A {@link CompletableFuture} containing the deserialized object. If the response body cannot
	 * by deserialized, the future will complete exceptionally.
	 */
	protected static <T> CompletableFuture<T> bodyToObjectFuture(Response response, Type type)
	{
		try
		{
			T t = bodyToObject(response, type);
			return CompletableFuture.completedFuture(t);
		}
		catch (IOException e)
		{
			CompletableFuture<T> failed = new CompletableFuture<>();
			failed.completeExceptionally(e);
			return failed;
		}
	}

	protected static <T> String objectToJson(T t)
	{
		return GSON.toJson(t);
	}

	private static String createUserAgent()
	{
		return RuneLiteAPI.userAgent;
	}

	private static HttpUrl createApiBaseUrl()
	{
		return RuneLiteAPI.getApiBase();
	}

	private static HttpUrl createStaticBaseUrl()
	{
		return RuneLiteAPI.getStaticBase();
	}

	private static class OkHttpFutureResponse implements Callback
	{

		@Getter
		private final CompletableFuture<Response> future;

		public OkHttpFutureResponse()
		{
			this.future = new CompletableFuture<>();
		}

		@Override
		public void onFailure(Call call, IOException e)
		{
			log.warn("API client error", e);
			future.completeExceptionally(e);
		}

		@Override
		public void onResponse(Call call, Response response)
		{
			future.complete(response);
		}
	}

	private static class RuneLiteInterceptor implements Interceptor
	{

		@Override
		public Response intercept(Chain chain) throws IOException
		{
			Request request = chain.request()
				.newBuilder()
				.header("User-Agent", createUserAgent())
				.build();

			log.debug(String.format("Built URL: %s", request.url().toString()));

			Response response = chain.proceed(request);

			// TODO: retry on failure
			if (!response.isSuccessful())
			{
				log.warn(String.format("(%s) API response error: %s", response.request().url(), response.message()));
				response.close();
				throw new IOException(String.format("%d: %s", response.code(), response.message()));
			}

			return response;
		}
	}
}
