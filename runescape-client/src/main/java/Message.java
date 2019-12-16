import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("Message")
public class Message extends DualNode {
	@ObfuscatedName("rp")
	@ObfuscatedSignature(
		signature = "Lbi;"
	)
	@Export("friendSystem")
	public static FriendSystem friendSystem;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		signature = "Lbn;"
	)
	@Export("localPlayer")
	static Player localPlayer;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2145696747
	)
	@Export("count")
	int count;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1217348159
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1995619175
	)
	@Export("type")
	int type;
	@ObfuscatedName("w")
	@Export("sender")
	String sender;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("senderUsername")
	Username senderUsername;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljf;"
	)
	@Export("isFromFriend0")
	TriBool isFromFriend0;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljf;"
	)
	@Export("isFromIgnored0")
	TriBool isFromIgnored0;
	@ObfuscatedName("x")
	@Export("prefix")
	String prefix;
	@ObfuscatedName("a")
	@Export("text")
	String text;

	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown;
		this.isFromIgnored0 = TriBool.TriBool_unknown;
		this.set(var1, var2, var3, var4);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-220493658"
	)
	@Export("set")
	void set(int var1, String var2, String var3, String var4) {
		int var5 = ++Messages.Messages_count - 1;
		this.count = var5;
		this.cycle = Client.cycle;
		this.type = var1;
		this.sender = var2;
		this.fillSenderUsername();
		this.prefix = var3;
		this.text = var4;
		this.clearIsFromFriend();
		this.clearIsFromIgnored();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1286059763"
	)
	@Export("clearIsFromFriend")
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2036111403"
	)
	@Export("isFromFriend")
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) {
			this.fillIsFromFriend();
		}

		return this.isFromFriend0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-928158145"
	)
	@Export("fillIsFromFriend")
	void fillIsFromFriend() {
		this.isFromFriend0 = friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "450069868"
	)
	@Export("clearIsFromIgnored")
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1235036606"
	)
	@Export("isFromIgnored")
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
			this.fillIsFromIgnored();
		}

		return this.isFromIgnored0 == TriBool.TriBool_true;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "80"
	)
	@Export("fillIsFromIgnored")
	void fillIsFromIgnored() {
		this.isFromIgnored0 = friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1271622880"
	)
	@Export("fillSenderUsername")
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(WorldMapManager.method662(this.sender), class188.loginType);
		} else {
			this.senderUsername = null;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/io/File;",
		garbageValue = "25"
	)
	@Export("getFile")
	static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(GrandExchangeOfferNameComparator.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1512311180"
	)
	public static void method1223() {
		class325.SpriteBuffer_xOffsets = null;
		class325.SpriteBuffer_yOffsets = null;
		UserComparator1.SpriteBuffer_spriteWidths = null;
		class325.SpriteBuffer_spriteHeights = null;
		class268.SpriteBuffer_spritePalette = null;
		class290.SpriteBuffer_pixels = null;
	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(Liv;IIII)V",
		garbageValue = "-860249391"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.areaSoundEffectVolume != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
				}
			}
		}
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(Lbv;IB)V",
		garbageValue = "58"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		SequenceDefinition var2;
		int var11;
		if (var0.field950 > Client.cycle) {
			ScriptEvent.method1180(var0);
		} else if (var0.field969 >= Client.cycle) {
			WorldMapSectionType.method239(var0);
		} else {
			var0.movementSequence = var0.readySequence;
			if (var0.pathLength == 0) {
				var0.field980 = 0;
			} else {
				label416: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						var2 = WorldMapSection0.SequenceDefinition_get(var0.sequence);
						if (var0.field926 > 0 && var2.field3478 == 0) {
							++var0.field980;
							break label416;
						}

						if (var0.field926 <= 0 && var2.field3493 == 0) {
							++var0.field980;
							break label416;
						}
					}

					var11 = var0.x;
					int var12 = var0.y;
					int var4 = var0.pathX[var0.pathLength - 1] * 128 + var0.field925 * 64;
					int var5 = var0.pathY[var0.pathLength - 1] * 128 + var0.field925 * 64;
					if (var11 < var4) {
						if (var12 < var5) {
							var0.orientation = 1280;
						} else if (var12 > var5) {
							var0.orientation = 1792;
						} else {
							var0.orientation = 1536;
						}
					} else if (var11 > var4) {
						if (var12 < var5) {
							var0.orientation = 768;
						} else if (var12 > var5) {
							var0.orientation = 256;
						} else {
							var0.orientation = 512;
						}
					} else if (var12 < var5) {
						var0.orientation = 1024;
					} else if (var12 > var5) {
						var0.orientation = 0;
					}

					byte var6 = var0.pathTraversed[var0.pathLength - 1];
					if (var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var12 <= 256 && var5 - var12 >= -256) {
						int var7 = var0.orientation - var0.rotation & 2047;
						if (var7 > 1024) {
							var7 -= 2048;
						}

						int var8 = var0.walkBackSequence;
						if (var7 >= -256 && var7 <= 256) {
							var8 = var0.walkSequence;
						} else if (var7 >= 256 && var7 < 768) {
							var8 = var0.walkRightSequence;
						} else if (var7 >= -768 && var7 <= -256) {
							var8 = var0.walkLeftSequence;
						}

						if (var8 == -1) {
							var8 = var0.walkSequence;
						}

						var0.movementSequence = var8;
						int var9 = 4;
						boolean var10 = true;
						if (var0 instanceof NPC) {
							var10 = ((NPC)var0).definition.isClickable;
						}

						if (var10) {
							if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field968 != 0) {
								var9 = 2;
							}

							if (var0.pathLength > 2) {
								var9 = 6;
							}

							if (var0.pathLength > 3) {
								var9 = 8;
							}

							if (var0.field980 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field980;
							}
						} else {
							if (var0.pathLength > 1) {
								var9 = 6;
							}

							if (var0.pathLength > 2) {
								var9 = 8;
							}

							if (var0.field980 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field980;
							}
						}

						if (var6 == 2) {
							var9 <<= 1;
						}

						if (var9 >= 8 && var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
							var0.movementSequence = var0.runSequence;
						}

						if (var11 != var4 || var5 != var12) {
							if (var11 < var4) {
								var0.x += var9;
								if (var0.x > var4) {
									var0.x = var4;
								}
							} else if (var11 > var4) {
								var0.x -= var9;
								if (var0.x < var4) {
									var0.x = var4;
								}
							}

							if (var12 < var5) {
								var0.y += var9;
								if (var0.y > var5) {
									var0.y = var5;
								}
							} else if (var12 > var5) {
								var0.y -= var9;
								if (var0.y < var5) {
									var0.y = var5;
								}
							}
						}

						if (var4 == var0.x && var5 == var0.y) {
							--var0.pathLength;
							if (var0.field926 > 0) {
								--var0.field926;
							}
						}
					} else {
						var0.x = var4;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field926 > 0) {
							--var0.field926;
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field950 = 0;
			var0.field969 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field925 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field925 * 64;
			var0.method1742();
		}

		if (localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field950 = 0;
			var0.field969 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field925 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field925 * 64;
			var0.method1742();
		}

		class3.method48(var0);
		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			var2 = WorldMapSection0.SequenceDefinition_get(var0.movementSequence);
			if (var2 != null && var2.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var2.frameIds.length && var0.movementFrameCycle > var2.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					addSequenceSoundEffect(var2, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var2.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					addSequenceSoundEffect(var2, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field943) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var11 = ClientPacket.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var11 != -1) {
				SequenceDefinition var3 = WorldMapSection0.SequenceDefinition_get(var11);
				if (var3 != null && var3.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var3.frameIds.length && var0.spotAnimationFrameCycle > var3.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						addSequenceSoundEffect(var3, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var3.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var3.frameIds.length)) {
						var0.spotAnimation = -1;
					}
				} else {
					var0.spotAnimation = -1;
				}
			} else {
				var0.spotAnimation = -1;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var2 = WorldMapSection0.SequenceDefinition_get(var0.sequence);
			if (var2.field3478 == 1 && var0.field926 > 0 && var0.field950 <= Client.cycle && var0.field969 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var2 = WorldMapSection0.SequenceDefinition_get(var0.sequence);
			if (var2 != null && var2.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var2.frameIds.length && var0.sequenceFrameCycle > var2.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					addSequenceSoundEffect(var2, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var2.frameIds.length) {
					var0.sequenceFrame -= var2.frameCount;
					++var0.field958;
					if (var0.field958 >= var2.field3496) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var2.frameIds.length) {
						addSequenceSoundEffect(var2, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var2.field3488;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}
}
