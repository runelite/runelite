/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.itemcharges;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.Data;
import net.runelite.client.Notifier;

/**
 * Allows the various {@link ItemWithVarCharge} items to be handled in the same way, regardless if configuration
 * for said element exists. All items can invoke the same methods, useful in cases such as the "check" option which all
 * use the server message. When a callback has not been configured, it defaults to a sensible default.
 */
@Singleton
class ItemConfigRegistry
{
	private final Map<ItemWithVarCharge, CallbackRegistry> CALLBACK_REGISTRY;

	@Inject
	private ItemConfigRegistry(ItemChargeConfig config, Notifier notifier)
	{
		CALLBACK_REGISTRY = Arrays.stream(ItemWithVarCharge.values())
			.collect(Collectors.toMap(Function.identity(),
				item -> new CallbackRegistry(),
				(l, r) ->
				{
					throw new IllegalArgumentException(String.format("Duplicate keys found for [%s] and [%s]", l, r));
				},
				() -> new EnumMap<>(ItemWithVarCharge.class)));

		registerChargesConsumer(ItemWithVarCharge.DODGY_NECKLACE, config::dodgyNecklace);
		registerChargesSupplier(ItemWithVarCharge.DODGY_NECKLACE, config::dodgyNecklace);
		registerRenderChargesSupplier(ItemWithVarCharge.DODGY_NECKLACE, config::showDodgyCount);
		registerSendNotificationSupplier(ItemWithVarCharge.DODGY_NECKLACE, config::dodgyNotification);
		registerNotificationConsumer(ItemWithVarCharge.DODGY_NECKLACE, notifier::notify);

		registerChargesConsumer(ItemWithVarCharge.RING_OF_RECOIL, config::ringOfRecoil);
		registerChargesSupplier(ItemWithVarCharge.RING_OF_RECOIL, config::ringOfRecoil);
		registerRenderChargesSupplier(ItemWithVarCharge.RING_OF_RECOIL, config::showRecoilCount);
		registerSendNotificationSupplier(ItemWithVarCharge.RING_OF_RECOIL, config::recoilNotification);
		registerNotificationConsumer(ItemWithVarCharge.RING_OF_RECOIL, notifier::notify);
	}

	private void registerChargesConsumer(ItemWithVarCharge itemType, Consumer<Integer> chargeConsumer)
	{
		CALLBACK_REGISTRY.get(itemType).setChargesConsumer(chargeConsumer);
	}

	private void registerRenderChargesSupplier(ItemWithVarCharge itemType, Supplier<Boolean> renderSupplier)
	{
		CALLBACK_REGISTRY.get(itemType).setRenderChargesSupplier(renderSupplier);
	}

	private void registerChargesSupplier(ItemWithVarCharge itemType, Supplier<Integer> chargesSupplier)
	{
		CALLBACK_REGISTRY.get(itemType).setChargesSupplier(chargesSupplier);
	}

	private void registerNotificationConsumer(ItemWithVarCharge itemType, Consumer<String> notificationConsumer)
	{
		CALLBACK_REGISTRY.get(itemType).setNotificationConsumer(notificationConsumer);
	}

	private void registerSendNotificationSupplier(ItemWithVarCharge itemType, Supplier<Boolean> sendNotificationSupplier)
	{
		CALLBACK_REGISTRY.get(itemType).setSendNotificationSupplier(sendNotificationSupplier);
	}

	void setCharges(ItemWithVarCharge itemType, Integer charges)
	{
		CALLBACK_REGISTRY.get(itemType)
			.getChargesConsumer()
			.ifPresent(c -> c.accept(charges));
	}

	boolean mayRender(ItemWithVarCharge itemType)
	{
		return CALLBACK_REGISTRY.get(itemType)
			.getRenderChargesSupplier()
			.orElse(() -> false)
			.get();
	}

	int getCharges(ItemWithVarCharge itemType)
	{
		return CALLBACK_REGISTRY.get(itemType)
			.getChargesSupplier()
			.orElse(() -> -1)
			.get();
	}

	void sendNotificationIfEnabled(ItemWithVarCharge itemType, String notification)
	{
		if (maySendNotification(itemType))
		{
			CALLBACK_REGISTRY.get(itemType)
				.getNotificationConsumer()
				.ifPresent(c -> c.accept(notification));
		}
	}

	private boolean maySendNotification(ItemWithVarCharge itemType)
	{
		return CALLBACK_REGISTRY.get(itemType)
			.getSendNotificationSupplier()
			.orElse(() -> false)
			.get();
	}


	@Data
	private static final class CallbackRegistry
	{
		private Consumer<Integer> chargesConsumer;
		private Supplier<Integer> chargesSupplier;
		private Supplier<Boolean> renderChargesSupplier;

		private Consumer<String> notificationConsumer;
		private Supplier<Boolean> sendNotificationSupplier;

		private Optional<Consumer<Integer>> getChargesConsumer()
		{
			return Optional.ofNullable(chargesConsumer);
		}

		private Optional<Supplier<Integer>> getChargesSupplier()
		{
			return Optional.ofNullable(chargesSupplier);
		}

		private Optional<Supplier<Boolean>> getRenderChargesSupplier()
		{
			return Optional.ofNullable(renderChargesSupplier);
		}

		private Optional<Consumer<String>> getNotificationConsumer()
		{
			return Optional.ofNullable(notificationConsumer);
		}

		private Optional<Supplier<Boolean>> getSendNotificationSupplier()
		{
			return Optional.ofNullable(sendNotificationSupplier);
		}
	}
}
