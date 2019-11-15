package net.runelite.client.plugins.slayermusiq;

import net.runelite.api.ChatMessageType;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.util.LinkBrowser;

class QuestGuideLinks
{
	private static final Link[] QUEST_GUIDE_LINKS = {
		// Free Quests
		new Link("Cook's Assistant", "https://www.youtube.com/watch?v=ehmtDRelj3c"),
		new Link("Romeo & Juliet", "https://www.youtube.com/watch?v=rH_biWSNWVY"),
		new Link("Demon Slayer", "https://www.youtube.com/watch?v=hgACrzJSiQk"),
		new Link("Shield of Arrav", "https://www.youtube.com/watch?v=a_imLDKUdzg"),
		new Link("Sheep Shearer", "https://www.youtube.com/watch?v=XFG3aNwK68s"),
		new Link("The Restless Ghost", "https://www.youtube.com/watch?v=UkWNcsG_pXM"),
		new Link("Ernest the Chicken", "https://www.youtube.com/watch?v=cq8NIVhSqh4"),
		new Link("Vampire Slayer", "https://www.youtube.com/watch?v=FcEuxsDJWCU"),
		new Link("Imp Catcher", "https://www.youtube.com/watch?v=LHgnl0FbOzk"),
		new Link("Prince Ali Rescue", "https://www.youtube.com/watch?v=hrSPl1GfFaw"),
		new Link("Doric's Quest", "https://www.youtube.com/watch?v=5TYyxHU27a4"),
		new Link("Black Knights' Fortress", "https://www.youtube.com/watch?v=aekoZi3f9cU"),
		new Link("Witch's Potion", "https://www.youtube.com/watch?v=XV4i5sPUvXo"),
		new Link("The Knight's Sword", "https://www.youtube.com/watch?v=UkBWaI0rOqE"),
		new Link("Goblin Diplomacy", "https://www.youtube.com/watch?v=P9BKOb_dLoY"),
		new Link("Pirate's Treasure", "https://www.youtube.com/watch?v=zcD87PQW8Qk"),
		new Link("Dragon Slayer", "https://www.youtube.com/watch?v=bMtCjlFOaBI"),
		new Link("Rune Mysteries", "https://www.youtube.com/watch?v=l8ZhaN8uoS0"),
		new Link("Misthalin Mystery", "https://www.youtube.com/watch?v=QlFqVAobAlQ"),
		new Link("The Corsair Curse", "https://www.youtube.com/watch?v=wi7mUAHExz4"),
		new Link("X Marks the Spot", "https://www.youtube.com/watch?v=GhRgvEG5jxQ"),
		// Members Quests
		new Link("Druidic Ritual", "https://www.youtube.com/watch?v=QIfU6HSmH4w"),
		new Link("Lost City", "https://www.youtube.com/watch?v=T-kQNUSjFZI"),
		new Link("Witch's House", "https://www.youtube.com/watch?v=TLsg7Wa-LUA"),
		new Link("Merlin's Crystal", "https://www.youtube.com/watch?v=ESX-qriNtCE"),
		new Link("Heroes' Quest", "https://www.youtube.com/watch?v=hK2N0WLKviE"),
		new Link("Scorpion Catcher", "https://www.youtube.com/watch?v=xpqdec7_ZWg"),
		new Link("Family Crest", "https://www.youtube.com/watch?v=0mk_Cgjr738"),
		new Link("Monk's Friend", "https://www.youtube.com/watch?v=avi4y4G3Hcw"),
		new Link("Temple of Ikov", "https://www.youtube.com/watch?v=5K7jDgr_4Z4"),
		new Link("Clock Tower", "https://www.youtube.com/watch?v=GUCkkQFzyDw"),
		new Link("Holy Grail", "https://www.youtube.com/watch?v=cgXoV1QlYco"),
		new Link("Tree Gnome Village", "https://www.youtube.com/watch?v=T6Su__yuyRI"),
		new Link("Fight Arena", "https://www.youtube.com/watch?v=4Nqjep2E5pw"),
		new Link("Hazeel Cult", "https://www.youtube.com/watch?v=2_fhFJW6cNY"),
		new Link("Sheep Herder", "https://www.youtube.com/watch?v=akC9FeYCG1Q"),
		new Link("Plague City", "https://www.youtube.com/watch?v=Hf2wQQZL5CU"),
		new Link("Waterfall Quest", "https://www.youtube.com/watch?v=xWBSnGkQTi4"),
		new Link("Jungle Potion", "https://www.youtube.com/watch?v=xqLKsFz08As"),
		new Link("The Grand Tree", "https://www.youtube.com/watch?v=N5e_Jus_E-Y"),
		new Link("Underground Pass", "https://www.youtube.com/watch?v=5klGJg1wY8k"),
		new Link("Observatory Quest", "https://www.youtube.com/watch?v=yxa9B6svv44"),
		new Link("Watchtower", "https://www.youtube.com/watch?v=Vb10GoYP7FE"),
		new Link("Dwarf Cannon", "https://www.youtube.com/watch?v=pROFg5jcCR0"),
		new Link("Murder Mystery", "https://www.youtube.com/watch?v=P1IDGCA2f9o"),
		new Link("The Dig Site", "https://www.youtube.com/watch?v=TOdcWV4MzuU"),
		new Link("Gertrude's Cat", "https://www.youtube.com/watch?v=g7S09wA8EAY"),
		new Link("Legends' Quest", "https://www.youtube.com/watch?v=Lid8enDEF_U"),
		new Link("Death Plateau", "https://www.youtube.com/watch?v=SIQFmTvnb6w"),
		new Link("Big Chompy Bird Hunting", "https://www.youtube.com/watch?v=s2fytMOHJXI"),
		new Link("Elemental Workshop I", "https://www.youtube.com/watch?v=tbZD2RDqvfQ"),
		new Link("Nature Spirit", "https://www.youtube.com/watch?v=Enf8vUWb5o0"),
		new Link("Priest in Peril", "https://www.youtube.com/watch?v=fyYri6wUQIU"),
		new Link("Regicide", "https://www.youtube.com/watch?v=KkWM-ok3C4Y"),
		new Link("Tai Bwo Wannai Trio", "https://www.youtube.com/watch?v=Mdair5mvZL0"),
		new Link("Troll Stronghold", "https://www.youtube.com/watch?v=zqmUs-f3AKA"),
		new Link("Horror from the Deep", "https://www.youtube.com/watch?v=9htK8kb6DR8"),
		new Link("Throne of Miscellania", "https://www.youtube.com/watch?v=fzGMnv2skBE"),
		new Link("Monkey Madness I", "https://www.youtube.com/watch?v=VnoRfeBnPFA"),
		new Link("Haunted Mine", "https://www.youtube.com/watch?v=cIc6loJHm9Q"),
		new Link("Troll Romance", "https://www.youtube.com/watch?v=j2zifZVu7Gc"),
		new Link("In Search of the Myreque", "https://www.youtube.com/watch?v=5nmYFHdAXAQ"),
		new Link("Creature of Fenkenstrain", "https://www.youtube.com/watch?v=swqUVIs7B7M"),
		new Link("Roving Elves", "https://www.youtube.com/watch?v=J3qf9DnT9cA"),
		new Link("One Small Favour", "https://www.youtube.com/watch?v=ix_0-W3e9ps"),
		new Link("Mountain Daughter", "https://www.youtube.com/watch?v=HETx_LX7aiY"),
		new Link("Between a Rock...", "https://www.youtube.com/watch?v=cB11I45EGgA"),
		new Link("The Golem", "https://www.youtube.com/watch?v=qpEHpiO6lLw"),
		new Link("Desert Treasure", "https://www.youtube.com/watch?v=BuIqulIsICo"),
		new Link("Icthlarin's Little Helper", "https://www.youtube.com/watch?v=wpNKm8_vUOM"),
		new Link("Tears of Guthix", "https://www.youtube.com/watch?v=EMonDNI0uPk"),
		new Link("The Lost Tribe", "https://www.youtube.com/watch?v=spZErjRnCdc"),
		new Link("The Giant Dwarf", "https://www.youtube.com/watch?v=Z7PsGpOYgxY"),
		new Link("Recruitment Drive", "https://www.youtube.com/watch?v=sOuzMpA_xtw"),
		new Link("Mourning's End Part I", "https://www.youtube.com/watch?v=vuzAdk-h3c0"),
		new Link("Garden of Tranquillity", "https://www.youtube.com/watch?v=7hbCzYnLCsQ"),
		new Link("A Tail of Two Cats", "https://www.youtube.com/watch?v=SgN9Yw_YqHk"),
		new Link("Wanted!", "https://www.youtube.com/watch?v=ZHZAKDCfXGs"),
		new Link("Mourning's End Part II", "https://www.youtube.com/watch?v=FK5sLogGbU8"),
		new Link("Rum Deal", "https://www.youtube.com/watch?v=I14CIu5x2S8"),
		new Link("Shadow of the Storm", "https://www.youtube.com/watch?v=5ZvWd3XCQjI"),
		new Link("Ratcatchers", "https://www.youtube.com/watch?v=s7G22fEuhTc"),
		new Link("Spirits of the Elid", "https://www.youtube.com/watch?v=A1zAX55hZC0"),
		new Link("Devious Minds", "https://www.youtube.com/watch?v=_UtlFmrWt1w"),
		new Link("Enakhra's Lament", "https://www.youtube.com/watch?v=Y3kEIPYVaVE"),
		new Link("Cabin Fever", "https://www.youtube.com/watch?v=k5DtxNXhOaw"),
		new Link("Fairytale I - Growing Pains", "https://www.youtube.com/watch?v=cfGI9qFOmsg"),
		new Link("Recipe for Disaster", "https://www.youtube.com/watch?v=hrAyyInJaTA"),
		new Link("In Aid of the Myreque", "https://www.youtube.com/watch?v=O2Ru2NmuTaA"),
		new Link("A Soul's Bane", "https://www.youtube.com/watch?v=dp8dp79qp6I"),
		new Link("Rag and Bone Man", "https://www.youtube.com/watch?v=3owXSeN56W8"),
		new Link("Swan Song", "https://www.youtube.com/watch?v=IpmERThXv2g"),
		new Link("Royal Trouble", "https://www.youtube.com/watch?v=bVWUlKzNXEg"),
		new Link("Death to the Dorgeshuun", "https://www.youtube.com/watch?v=2XJHuLhig98"),
		new Link("Fairytale II - Cure a Queen", "https://www.youtube.com/watch?v=P6KkRk4_e3U"),
		new Link("Lunar Diplomacy", "https://www.youtube.com/watch?v=vmeSKb7IBgQ"),
		new Link("The Eyes of Glouphrie", "https://www.youtube.com/watch?v=0YCPwmZcxKA"),
		new Link("Darkness of Hallowvale", "https://www.youtube.com/watch?v=QziKl99qdtU"),
		new Link("Elemental Workshop II", "https://www.youtube.com/watch?v=Bb4E7ecIgv0"),
		new Link("My Arm's Big Adventure", "https://www.youtube.com/watch?v=xa1KWOewgYA"),
		new Link("Enlightened Journey", "https://www.youtube.com/watch?v=XAPthC8d7k0"),
		new Link("Eagles' Peak", "https://www.youtube.com/watch?v=KDxIrrwXp7U"),
		new Link("Animal Magnetism", "https://www.youtube.com/watch?v=_JldgJTnc7I"),
		new Link("Contact!", "https://www.youtube.com/watch?v=czn-yWABBWs"),
		new Link("Cold War", "https://www.youtube.com/watch?v=0m1KpP-qKWI"),
		new Link("The Fremennik Isles", "https://www.youtube.com/watch?v=EvxhiOWmraY"),
		new Link("The Great Brain Robbery", "https://www.youtube.com/watch?v=ImHFASuNUN8"),
		new Link("What Lies Below", "https://www.youtube.com/watch?v=f_9nVMGTtuo"),
		new Link("Olaf's Quest", "https://www.youtube.com/watch?v=mXV5bM1NFMM"),
		new Link("Dream Mentor", "https://www.youtube.com/watch?v=XDLUu0Kf0sE"),
		new Link("Grim Tales", "https://www.youtube.com/watch?v=dFB0Q6v8Apw"),
		new Link("King's Ransom", "https://www.youtube.com/watch?v=UJz9ZfF3uCY"),
		new Link("Shilo Village", "https://www.youtube.com/watch?v=bDvBi8FT-QI"),
		new Link("Biohazard", "https://www.youtube.com/watch?v=n9k87LwOGMk"),
		new Link("Tower of Life", "https://www.youtube.com/watch?v=KReMcWpeY3k"),
		new Link("Rag and Bone Man II", "https://www.youtube.com/watch?v=KGdHiDDUX_U"),
		new Link("Zogre Flesh Eaters", "https://www.youtube.com/watch?v=vzm4949kXP4"),
		new Link("Monkey Madness II", "https://www.youtube.com/watch?v=ykE5LbjABaI"),
		new Link("Client of Kourend", "https://www.youtube.com/watch?v=Y-KIHF-cL9w"),
		new Link("The Queen of Thieves", "https://www.youtube.com/watch?v=W94zFZVrHkQ"),
		new Link("Bone Voyage", "https://www.youtube.com/watch?v=-VTR4p8kPmI"),
		new Link("Dragon Slayer II", "https://www.youtube.com/watch?v=4BMb3Zwzk_U"),
		new Link("The Depths of Despair", "https://www.youtube.com/watch?v=CaVUk2eAsKs"),
		new Link("A Taste of Hope", "https://www.youtube.com/watch?v=VjdgEIizdSc"),
		new Link("Tale of the Righteous", "https://www.youtube.com/watch?v=99yiv0tPl58"),
		new Link("Making Friends with My Arm", "https://www.youtube.com/watch?v=DltzzhIsM_Q"),
		new Link("The Ascent of Arceuus", "https://www.youtube.com/watch?v=4VQnfrv6S18"),
		new Link("The Forsaken Tower", "https://www.youtube.com/watch?v=con0sXl5NBY"),
		new Link("Fishing Contest", "https://www.youtube.com/watch?v=XYSv37A_l5w"),
		new Link("Tribal Totem", "https://www.youtube.com/watch?v=XkUEIjr886M"),
		new Link("Sea Slug", "https://www.youtube.com/watch?v=oOZVfa5SkVQ"),
		new Link("The Tourist Trap", "https://www.youtube.com/watch?v=0bmSCCepMvo"),
		new Link("Eadgar's Ruse", "https://www.youtube.com/watch?v=aVQ3DjTElXg"),
		new Link("Shades of Mort'ton", "https://www.youtube.com/watch?v=eF05R8OMxgg"),
		new Link("The Fremennik Trials", "https://www.youtube.com/watch?v=YUIvEgcvl5c"),
		new Link("Ghosts Ahoy", "https://www.youtube.com/watch?v=aNBkLOywDfM"),
		new Link("The Feud", "https://www.youtube.com/watch?v=nlBSc9IUklA"),
		new Link("Forgettable Tale...", "https://www.youtube.com/watch?v=3HvFd6AxNU0"),
		new Link("Making History", "https://www.youtube.com/watch?v=bOTGi2zAuhs"),
		new Link("The Hand in the Sand", "https://www.youtube.com/watch?v=gdNLcZ-l1Lw"),
		new Link("The Slug Menace", "https://www.youtube.com/watch?v=BRQbdr3JEZ8"),
		new Link("Another Slice of H.A.M.", "https://www.youtube.com/watch?v=Yq3db7827Lk"),
		new Link("Song of the Elves", "https://www.youtube.com/watch?v=oMGvdBCuxoY"),
		new Link("The Fremennik Exiles", "https://www.youtube.com/watch?v=1Vz2rXYhi4E"),
		//Miniquests
		new Link("Alfred Grimhand's Barcrawl", "https://www.youtube.com/watch?v=hE2dmiDaoK4"),
		new Link("Bear your Soul", "https://www.youtube.com/watch?v=Pb6N-_6HJNc"),
		new Link("Curse of the Empty Lord", "https://www.youtube.com/watch?v=efv9mlHdeK0"),
		new Link("Enter the Abyss", "https://www.youtube.com/watch?v=0rDADV0GKN8"),
		new Link("Family Pest", "https://www.youtube.com/watch?v=Iie2_Si8iDg"),
		new Link("The General's Shadow", "https://www.youtube.com/watch?v=4bIYZpRvewA"),
		new Link("Lair of Tarn Razorlor", "https://www.youtube.com/watch?v=rEhSkhviK5E"),
		new Link("The Mage Arena", "https://www.youtube.com/watch?v=UyncI4hgmtY"),
		new Link("Skippy and the Mogres", "https://www.youtube.com/watch?v=cU0H6QVXcG0")
	};

	private static class Link
	{

		private final String questName;
		private final String url;

		Link(String questName, String url)
		{
			this.questName = questName;
			this.url = url;
		}

		String getQuestName()
		{
			return questName;
		}

		void openURL()
		{
			LinkBrowser.browse(this.url);
		}

	}

	private static boolean openGuide(String questName)
	{
		for (Link link : QUEST_GUIDE_LINKS)
		{
			if (link.getQuestName().equals(questName))
			{
				link.openURL();
				return true;
			}
		}
		return false;
	}

	private static void logQuestNotFoundError(String questName, ChatMessageManager chatMessageManager)
	{
		String chatMessage = new ChatMessageBuilder()
			.append(ChatColorType.HIGHLIGHT)
			.append("Could not find Slayermusiq1 guide for " + questName)
			.build();

		chatMessageManager.queue(QueuedMessage.builder()
			.type(ChatMessageType.GAMEMESSAGE)
			.runeLiteFormattedMessage(chatMessage)
			.build());
	}

	static void tryOpenGuide(String questName, ChatMessageManager chatMessageManager)
	{
		boolean success = openGuide(questName);
		if (!success)
		{
			logQuestNotFoundError(questName, chatMessageManager);
		}
	}
}
