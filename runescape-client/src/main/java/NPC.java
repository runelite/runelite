import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("i")
	@Export("SpriteBuffer_yOffsets")
	public static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	@Export("definition")
	NPCDefinition definition;

	NPC() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IBI)V",
		garbageValue = "-1099283793"
	)
	final void method2083(int var1, byte var2) {
		int var3 = super.pathX[0];
		int var4 = super.pathY[0];
		if (var1 == 0) {
			--var3;
			++var4;
		}

		if (var1 == 1) {
			++var4;
		}

		if (var1 == 2) {
			++var3;
			++var4;
		}

		if (var1 == 3) {
			--var3;
		}

		if (var1 == 4) {
			++var3;
		}

		if (var1 == 5) {
			--var3;
			--var4;
		}

		if (var1 == 6) {
			--var4;
		}

		if (var1 == 7) {
			++var3;
			--var4;
		}

		if (super.sequence != -1 && GraphicsDefaults.SequenceDefinition_get(super.sequence).field3524 == 1) {
			super.sequence = -1;
		}

		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var5 = super.pathLength; var5 > 0; --var5) {
			super.pathX[var5] = super.pathX[var5 - 1];
			super.pathY[var5] = super.pathY[var5 - 1];
			super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
		}

		super.pathX[0] = var3;
		super.pathY[0] = var4;
		super.pathTraversed[0] = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIZB)V",
		garbageValue = "0"
	)
	final void method2077(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && GraphicsDefaults.SequenceDefinition_get(super.sequence).field3524 == 1) {
			super.sequence = -1;
		}

		if (!var3) {
			int var4 = var1 - super.pathX[0];
			int var5 = var2 - super.pathY[0];
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
				if (super.pathLength < 9) {
					++super.pathLength;
				}

				for (int var6 = super.pathLength; var6 > 0; --var6) {
					super.pathX[var6] = super.pathX[var6 - 1];
					super.pathY[var6] = super.pathY[var6 - 1];
					super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
				}

				super.pathX[0] = var1;
				super.pathY[0] = var2;
				super.pathTraversed[0] = 1;
				return;
			}
		}

		super.pathLength = 0;
		super.field998 = 0;
		super.field997 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.pathX[0] * 128 + super.field942 * 2013925376;
		super.y = super.pathY[0] * 128 + super.field942 * 2013925376;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ldx;",
		garbageValue = "-2133076860"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? GraphicsDefaults.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && (super.movementSequence != super.readySequence || var1 == null) ? GraphicsDefaults.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = this.definition.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					Model var4 = class65.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var4 != null) {
						var4.offsetBy(0, -super.field980, 0);
						Model[] var5 = new Model[]{var3, var4};
						var3 = new Model(var5, 2);
					}
				}

				if (this.definition.size == 1) {
					var3.isSingleTile = true;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-515224238"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-728200028"
	)
	public static boolean method2088(int var0) {
		return (var0 >> 21 & 1) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-213957915"
	)
	static void method2079() {
		Login.loginIndex = 24;
		Tiles.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;I)V",
		garbageValue = "-1867991224"
	)
	@Export("widgetDefaultMenuAction")
	static void widgetDefaultMenuAction(int var0, int var1, int var2, int var3, String var4) {
		Widget var5 = SpriteMask.getWidgetChild(var1, var2);
		if (var5 != null) {
			if (var5.onOp != null) {
				ScriptEvent var6 = new ScriptEvent();
				var6.widget = var5;
				var6.opIndex = var0;
				var6.targetName = var4;
				var6.args = var5.onOp;
				class4.runScriptEvent(var6);
			}

			boolean var11 = true;
			if (var5.contentType > 0) {
				var11 = BufferedSink.method5915(var5);
			}

			if (var11) {
				int var8 = WorldMapIcon_0.getWidgetClickMask(var5);
				int var9 = var0 - 1;
				boolean var7 = (var8 >> var9 + 1 & 1) != 0;
				if (var7) {
					PacketBufferNode var10;
					if (var0 == 1) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 2) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2209, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 3) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 4) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 5) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 6) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 7) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2204, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 8) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 9) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

					if (var0 == 10) {
						var10 = TilePaint.getPacketBufferNode(ClientPacket.field2303, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(var1);
						var10.packetBuffer.writeShort(var2);
						var10.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var10);
					}

				}
			}
		}
	}
}
