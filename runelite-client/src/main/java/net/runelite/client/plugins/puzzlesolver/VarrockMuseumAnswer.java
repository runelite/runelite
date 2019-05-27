/*
 * Copyright (c) 2018, Viktor <Viktor.horsmanheimo@teknik.io>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.puzzlesolver;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Getter
@RequiredArgsConstructor
enum VarrockMuseumAnswer
{
	LIZARD_1("How does a lizard regulate body heat?", "Sunlight."),
	LIZARD_2("Who discovered how to kill lizards?", "The Slayer Masters."),
	LIZARD_3("How many eyes does a lizard have?", "Three."),
	LIZARD_4("What order do lizards belong to?", "Squamata."),
	LIZARD_5("What happens when a lizard becomes cold?", "It becomes sleepy."),
	LIZARD_6("Lizard skin is made of the same substance as?", "Hair."),

	TORTOISE_1("What is the name of the oldest tortoise ever recorded?", "Mibbiwocket."),
	TORTOISE_2("What is a tortoise's favourite food?", "Vegetables."),
	TORTOISE_3("Name the explorer who discovered the world's oldest tortoise.", "Admiral Bake."),
	TORTOISE_4("How does the tortoise protect itself?", "Hard shell."),
	TORTOISE_5("If a tortoise had twenty rings on its shell, how old would it be?", "Twenty years."),
	TORTOISE_6("Which race breeds tortoises for battle?", "Gnomes."),

	DRAGON_1("What is considered a delicacy by dragons?", "Runite."),
	DRAGON_2("What is the best defence against a dragon's attack?", "Anti dragon-breath shield."),
	DRAGON_3("How long do dragons live?", "Unknown."),
	DRAGON_4("Which of these is not a type of dragon?", "Elemental."),
	DRAGON_5("What is the favoured territory of a dragon?", "Old battle sites."),
	DRAGON_6("Approximately how many feet tall do dragons stand?", "Twelve."),

	WYVERN_1("How did the wyverns die out?", "Climate change."),
	WYVERN_2("How many legs does a wyvern have?", "Two."),
	WYVERN_3("Where have wyvern bones been found?", "Asgarnia."),
	WYVERN_4("Which genus does the wyvern theoretically belong to?", "Reptiles."),
	WYVERN_5("What are the wyverns' closest relations?", "Dragons."),
	WYVERN_6("What is the ambient temperature of wyvern bones?", "Below room temperature."),

	SNAIL_1("What is special about the shell of the giant Morytanian snail?", "It is resistant to acid."),
	SNAIL_2("How do Morytanian snails capture their prey?", "Spitting acid."),
	SNAIL_3("Which of these is a snail byproduct?", "Fireproof oil."),
	SNAIL_4("What does 'Achatina Acidia' mean?", "Acid-spitting snail."),
	SNAIL_5("How do snails move?", "Contracting and stretching."),
	SNAIL_6("What is the 'trapdoor', which snails use to cover the entrance to their shells called?", "An operculum."),

	SNAKE_1("What is snake venom adapted from?", "Stomach acid."),
	SNAKE_2("Aside from their noses, what do snakes use to smell?", "Tongue."),
	SNAKE_3("If a snake sticks its tongue out at you, what is it doing?", "Seeing how you smell."),
	SNAKE_4("If some snakes use venom to kill their prey, what do other snakes use?", "Constriction."),
	SNAKE_5("Lizards and snakes belong to the same order - what is it?", "Squamata."),
	SNAKE_6("Which habitat do snakes prefer?", "Anywhere."),

	SLUG_1("We assume that sea slugs have a stinging organ on their soft skin - what is it called?", "Nematocysts."),
	SLUG_2("Why has the museum never examined a live sea slug?", "The researchers keep vanishing."),
	SLUG_3("What do we think the sea slug feeds upon?", "Seaweed."),
	SLUG_4("What are the two fangs presumed to be used for?", "Defense or display."),
	SLUG_5("Off of which coastline would you find sea slugs?", "Ardougne."),
	SLUG_6("In what way are sea slugs similar to snails?", "They have a hard shell."),

	MONKEY_1("Which type of primates do monkeys belong to?", "Simian."),
	MONKEY_2("Which have the lighter colour: Karamjan or Harmless monkeys?", "Harmless."),
	MONKEY_3("Monkeys love bananas. What else do they like to eat?", "Bitternuts."),
	MONKEY_4("There are two known families of monkeys. One is Karamjan, the other is...?", "Harmless."),
	MONKEY_5("What colour mohawk do Karamjan monkeys have?", "Red."),
	MONKEY_6("What have Karamjan monkeys taken a deep dislike to?", "Seaweed."),

	KALPHITE_1("Kalphites are ruled by a...?", "Pasha."),
	KALPHITE_2("What is the lowest caste in kalphite society?", "Worker."),
	KALPHITE_3("What are the armoured plates on a kalphite called?", "Lamellae."),
	KALPHITE_4("Are kalphites carnivores, herbivores or omnivores?", "Carnivores."),
	KALPHITE_5("What are kalphites assumed to have evolved from?", "Scarab beetles."),
	KALPHITE_6("Name the prominent figure in kalphite mythology?", "Scabaras."),

	TERRORBIRD_1("What is a terrorbird's preferred food?", "Anything."),
	TERRORBIRD_2("Who use terrorbirds as mounts?", "Gnomes."),
	TERRORBIRD_3("Where do terrorbirds get most of their water?", "Eating plants."),
	TERRORBIRD_4("How many claws do terrorbirds have?", "Four."),
	TERRORBIRD_5("What do terrorbirds eat to aid digestion?", "Stones."),
	TERRORBIRD_6("How many teeth do terrorbirds have?", "0."),

	PENGUIN_1("Which sense do penguins rely on when hunting?", "Sight."),
	PENGUIN_2("Which skill seems unusual for the penguins to possess?", "Planning."),
	PENGUIN_3("How do penguins keep warm?", "A layer of fat."),
	PENGUIN_4("What is the preferred climate for penguins?", "Cold."),
	PENGUIN_5("Describe the behaviour of penguins?", "Social."),
	PENGUIN_6("When do penguins fast?", "During breeding."),

	MOLE_1("What habitat do moles prefer?", "Subterranean."),
	MOLE_2("Why are moles considered to be an agricultural pest?", "They dig holes."),
	MOLE_3("Who discovered giant moles?", "Wyson the Gardener."),
	MOLE_4("What would you call a group of young moles?", "A labour."),
	MOLE_5("What is a mole's favourite food?", "Insects and other invertebrates."),
	MOLE_6("Which family do moles belong to?", "The Talpidae family."),

	CAMEL_1("What is produced by feeding chilli to a camel?", "Toxic dung."),
	CAMEL_2("If an ugthanki has one, how many does a bactrian have?", "Two."),
	CAMEL_3("Camels: herbivore, carnivore or omnivore?", "Omnivore."),
	CAMEL_4("What is the usual mood for a camel?", "Annoyed."),
	CAMEL_5("Where would you find an ugthanki?", "Al Kharid."),
	CAMEL_6("Which camel byproduct is known to be very nutritious?", "Milk."),

	LEECH_1("What is the favoured habitat of leeches?", "Water."),
	LEECH_2("What shape is the inside of a leech's mouth?", "'Y'-shaped."),
	LEECH_3("Which of these is not eaten by leeches?", "Apples."),
	LEECH_4("What contributed to the giant growth of Morytanian leeches?", "Environment."),
	LEECH_5("What is special about Morytanian leeches?", "They attack by jumping."),
	LEECH_6("How does a leech change when it feeds?", "It doubles in size.");

	private static final Map<String, String> MATCHES;

	static
	{
		ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();

		for (VarrockMuseumAnswer varrockMuseumAnswer : VarrockMuseumAnswer.values())
		{
			builder.put(varrockMuseumAnswer.question, varrockMuseumAnswer.answer);
		}

		MATCHES = builder.build();
	}

	private final String question;
	private final String answer;

	static Widget findCorrect(final Client client, final String question, final WidgetInfo... widgets)
	{
		final String s = MATCHES.get(question);

		for (WidgetInfo widgetInfo : widgets)
		{
			final Widget widget = client.getWidget(widgetInfo);

			if (widget != null && widget.getText().equals(s))
			{
				return widget;
			}
		}

		return null;
	}
}
