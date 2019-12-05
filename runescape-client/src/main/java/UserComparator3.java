import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("UserComparator3")
public class UserComparator3 extends AbstractUserComparator {
	@ObfuscatedName("qg")
	@ObfuscatedGetter(
		intValue = -1789609461
	)
	static int field1990;
	@ObfuscatedName("u")
	@Export("reversed")
	final boolean reversed;

	public UserComparator3(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "81177431"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.world != var1.world) {
			return this.reversed ? var1.world - var2.world : var2.world - var1.world;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)Lhl;",
		garbageValue = "2096565459"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = Language.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "438202516"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (Widget.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!InvDefinition.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = InvDefinition.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				Widget.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (FloorDecoration.Widget_interfaceComponents[var0] == null) {
					FloorDecoration.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (FloorDecoration.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = InvDefinition.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							FloorDecoration.Widget_interfaceComponents[var0][var2] = new Widget();
							FloorDecoration.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								FloorDecoration.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								FloorDecoration.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				Widget.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1508425976"
	)
	static boolean method3476(int var0) {
		for (int var1 = 0; var1 < Client.field889; ++var1) {
			if (Client.field865[var1] == var0) {
				return true;
			}
		}

		return false;
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "(Lhl;IIB)V",
		garbageValue = "13"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null) {
				Widget var5 = var0;
				int var7 = MenuAction.getWidgetClickMask(var0);
				int var6 = var7 >> 17 & 7;
				int var8 = var6;
				Widget var4;
				int var9;
				if (var6 == 0) {
					var4 = null;
				} else {
					var9 = 0;

					while (true) {
						if (var9 >= var8) {
							var4 = var5;
							break;
						}

						var5 = Language.getWidget(var5.parentId);
						if (var5 == null) {
							var4 = null;
							break;
						}

						++var9;
					}
				}

				Widget var10 = var4;
				if (var4 == null) {
					var10 = var0.parent;
				}

				if (var10 != null) {
					Client.clickedWidget = var0;
					var5 = var0;
					var7 = MenuAction.getWidgetClickMask(var0);
					var6 = var7 >> 17 & 7;
					var8 = var6;
					if (var6 == 0) {
						var4 = null;
					} else {
						var9 = 0;

						while (true) {
							if (var9 >= var8) {
								var4 = var5;
								break;
							}

							var5 = Language.getWidget(var5.parentId);
							if (var5 == null) {
								var4 = null;
								break;
							}

							++var9;
						}
					}

					var10 = var4;
					if (var4 == null) {
						var10 = var0.parent;
					}

					Client.clickedWidgetParent = var10;
					Client.widgetClickX = var1;
					Client.widgetClickY = var2;
					class3.widgetDragDuration = 0;
					Client.isDraggingWidget = false;
					int var11 = Client.menuOptionsCount - 1;
					if (var11 != -1) {
						Tiles.tempMenuAction = new MenuAction();
						Tiles.tempMenuAction.param0 = Client.menuArguments1[var11];
						Tiles.tempMenuAction.param1 = Client.menuArguments2[var11];
						Tiles.tempMenuAction.opcode = Client.menuOpcodes[var11];
						Tiles.tempMenuAction.identifier = Client.menuIdentifiers[var11];
						Tiles.tempMenuAction.action = Client.menuActions[var11];
					}

					return;
				}
			}

		}
	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "65535"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (InterfaceParent.clanChat != null) {
			PacketBufferNode var1 = ModelData0.getPacketBufferNode(ClientPacket.field2296, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
