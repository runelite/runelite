import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bf")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;
	@ObfuscatedName("ed")
	static int[] field1074;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ljf;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1533704569
	)
	int field1076;

	@ObfuscatedSignature(
		signature = "(Lmu;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1076 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1493055205"
	)
	boolean method1791() {
		return this.field1076 == 2;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2033101779"
	)
	final void method1760() {
		this.field1076 = 1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "499123399"
	)
	final void method1805(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1076 = 2;
		VertexNormal.method2972();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "9"
	)
	final void method1762() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3661 < DirectByteArrayCopier.currentTimeMs() / 1000L - 5L) {
				if (var1.world > 0) {
					ScriptEvent.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					ScriptEvent.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "487"
	)
	@Export("clear")
	final void clear() {
		this.field1076 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljv;ZI)Z",
		garbageValue = "277105745"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(Client.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljv;B)Z",
		garbageValue = "-1"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1616773862"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddFriend()) {
					MouseRecorder.method1138();
				} else {
					StringBuilder var10000;
					String var4;
					if (Client.localPlayer.username.equals(var2)) {
						var10000 = null;
						var4 = "You can't add yourself to your own friend list";
						ScriptEvent.addGameMessage(30, "", var4);
					} else if (this.isFriended(var2, false)) {
						WorldMapManager.method633(var1);
					} else if (this.isIgnored(var2)) {
						var10000 = new StringBuilder();
						Object var10001 = null;
						var10000 = var10000.append("Please remove ").append(var1);
						var10001 = null;
						var4 = var10000.append(" from your ignore list first").toString();
						ScriptEvent.addGameMessage(30, "", var4);
					} else {
						PacketBufferNode var3 = Archive.method4265(ClientPacket.field2291, Client.packetWriter.isaacCipher);
						var3.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var1));
						var3.packetBuffer.writeStringCp1252NullTerminated(var1);
						Client.packetWriter.method2219(var3);
					}
				}
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1832843555"
	)
	@Export("canAddFriend")
	final boolean canAddFriend() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field771 != 1;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "1"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					Object var10000 = null;
					String var3 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
					ScriptEvent.addGameMessage(30, "", var3);
				} else if (Client.localPlayer.username.equals(var2)) {
					WorldMapEvent.method737();
				} else if (this.isIgnored(var2)) {
					Client.method1650(var1);
				} else if (this.isFriended(var2, false)) {
					WorldMapID.method541(var1);
				} else {
					class219.method4111(var1);
				}
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-81479393"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field771 != 1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1086170142"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					Client.field672 = Client.cycleCntr;
					PacketBufferNode var3 = Archive.method4265(ClientPacket.field2224, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.method2219(var3);
				}

				VertexNormal.method2972();
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "8"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					Client.field672 = Client.cycleCntr;
					PacketBufferNode var3 = Archive.method4265(ClientPacket.field2231, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.method2219(var3);
				}

				class2.method28();
			}
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljv;I)Z",
		garbageValue = "1053718867"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1745629182"
	)
	public static int method1819(int var0, int var1) {
		int var2;
		if (var1 > var0) {
			var2 = var0;
			var0 = var1;
			var1 = var2;
		}

		while (var1 != 0) {
			var2 = var0 % var1;
			var0 = var1;
			var1 = var2;
		}

		return var0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BIIB)Ljava/lang/String;",
		garbageValue = "52"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class288.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-77884497"
	)
	public static int method1784(int var0) {
		return class43.method770(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-680519065"
	)
	static int method1817(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERTYPE) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERITEM) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERPRICE) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFEREMPTY) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERSTABLE) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERFINISHED) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERADDING) {
				var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_NAME) {
					var13 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_PRICE) {
					var13 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTFILTERBY_WORLD) {
					HealthBarUpdate.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						PendingSpawn.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_AGE) {
					var13 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_COUNT) {
					var13 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
					if (PendingSpawn.grandExchangeEvents != null) {
						PendingSpawn.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_GETTOTALOFFERS) {
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = PendingSpawn.grandExchangeEvents == null ? 0 : PendingSpawn.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERWORLD) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERNAME) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var11.getOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPREVIOUSNAME) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERAGE) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						long var5 = DirectByteArrayCopier.currentTimeMs() - Buddy.field3632 - var11.age;
						int var7 = (int)(var5 / 3600000L);
						int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
						int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERCOUNT) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPRICE) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERITEM) {
						var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PendingSpawn.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}
