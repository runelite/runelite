import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("StructDefinition_archive")
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("StructDefinition_cached")
	public static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	StructDefinition() {
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "9298"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1347797517"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "-629371367"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = WorldMapArea.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1469740156"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		IterableNodeHashTable var4 = this.params;
		int var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			IntegerNode var5 = (IntegerNode)var4.get((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = var5.integer;
			}
		}

		return var3;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1883536215"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return GrandExchangeOfferWorldComparator.method54(this.params, var1, var2);
	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(Lbq;IB)V",
		garbageValue = "16"
	)
	@Export("calculateActorPosition")
	static final void calculateActorPosition(Actor var0, int var1) {
		int var2;
		int var3;
		int var4;
		SequenceDefinition var11;
		if (var0.field995 > Client.cycle) {
			var2 = var0.field995 - Client.cycle;
			var3 = var0.size * -1342954560 + var0.field991 * 128;
			var4 = var0.size * -1342954560 + var0.field993 * 128;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1007 = 0;
			var0.orientation = var0.field997;
		} else {
			int var5;
			int var7;
			if (var0.field996 >= Client.cycle) {
				if (var0.field996 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > GrandExchangeEvent.getSequenceDefinition(var0.sequence).frameLengths[var0.sequenceFrame]) {
					var2 = var0.field996 - var0.field995;
					var3 = Client.cycle - var0.field995;
					var4 = var0.size * -1342954560 + var0.field991 * 128;
					var5 = var0.field993 * 128 + var0.size * -1342954560;
					int var6 = var0.size * -1342954560 + var0.field992 * 128;
					var7 = var0.size * -1342954560 + var0.field983 * 128;
					var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
					var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
				}

				var0.field1007 = 0;
				var0.orientation = var0.field997;
				var0.field950 = var0.orientation;
			} else {
				var0.movementSequence = var0.readySequence;
				if (var0.pathLength == 0) {
					var0.field1007 = 0;
				} else {
					label434: {
						if (var0.sequence != -1 && var0.sequenceDelay == 0) {
							var11 = GrandExchangeEvent.getSequenceDefinition(var0.sequence);
							if (var0.field1008 > 0 && var11.field3525 == 0) {
								++var0.field1007;
								break label434;
							}

							if (var0.field1008 <= 0 && var11.field3532 == 0) {
								++var0.field1007;
								break label434;
							}
						}

						var2 = var0.x;
						var3 = var0.y;
						var4 = var0.size * -1342954560 + var0.pathX[var0.pathLength - 1] * 128;
						var5 = var0.size * -1342954560 + var0.pathY[var0.pathLength - 1] * 128;
						if (var2 < var4) {
							if (var3 < var5) {
								var0.orientation = 1280;
							} else if (var3 > var5) {
								var0.orientation = 1792;
							} else {
								var0.orientation = 1536;
							}
						} else if (var2 > var4) {
							if (var3 < var5) {
								var0.orientation = 768;
							} else if (var3 > var5) {
								var0.orientation = 256;
							} else {
								var0.orientation = 512;
							}
						} else if (var3 < var5) {
							var0.orientation = 1024;
						} else if (var3 > var5) {
							var0.orientation = 0;
						}

						byte var13 = var0.pathTraversed[var0.pathLength - 1];
						if (var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
							var7 = var0.orientation - var0.field950 & 2047;
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
								if (var0.orientation != var0.field950 && var0.targetIndex == -1 && var0.field948 != 0) {
									var9 = 2;
								}

								if (var0.pathLength > 2) {
									var9 = 6;
								}

								if (var0.pathLength > 3) {
									var9 = 8;
								}

								if (var0.field1007 > 0 && var0.pathLength > 1) {
									var9 = 8;
									--var0.field1007;
								}
							} else {
								if (var0.pathLength > 1) {
									var9 = 6;
								}

								if (var0.pathLength > 2) {
									var9 = 8;
								}

								if (var0.field1007 > 0 && var0.pathLength > 1) {
									var9 = 8;
									--var0.field1007;
								}
							}

							if (var13 == 2) {
								var9 <<= 1;
							}

							if (var9 >= 8 && var0.walkSequence == var0.movementSequence && var0.runSequence != -1) {
								var0.movementSequence = var0.runSequence;
							}

							if (var2 != var4 || var3 != var5) {
								if (var2 < var4) {
									var0.x += var9;
									if (var0.x > var4) {
										var0.x = var4;
									}
								} else if (var2 > var4) {
									var0.x -= var9;
									if (var0.x < var4) {
										var0.x = var4;
									}
								}

								if (var3 < var5) {
									var0.y += var9;
									if (var0.y > var5) {
										var0.y = var5;
									}
								} else if (var3 > var5) {
									var0.y -= var9;
									if (var0.y < var5) {
										var0.y = var5;
									}
								}
							}

							if (var4 == var0.x && var5 == var0.y) {
								--var0.pathLength;
								if (var0.field1008 > 0) {
									--var0.field1008;
								}
							}
						} else {
							var0.x = var4;
							var0.y = var5;
							--var0.pathLength;
							if (var0.field1008 > 0) {
								--var0.field1008;
							}
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field995 = 0;
			var0.field996 = 0;
			var0.x = var0.pathX[0] * 128 + var0.size * -1342954560;
			var0.y = var0.pathY[0] * 128 + var0.size * -1342954560;
			var0.method1658();
		}

		if (Client.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field995 = 0;
			var0.field996 = 0;
			var0.x = var0.size * -1342954560 + var0.pathX[0] * 128;
			var0.y = var0.pathY[0] * 128 + var0.size * -1342954560;
			var0.method1658();
		}

		Friend.method5226(var0);
		var0.field967 = false;
		if (var0.movementSequence != -1) {
			var11 = GrandExchangeEvent.getSequenceDefinition(var0.movementSequence);
			if (var11 != null && var11.frameIds != null) {
				++var0.movementFrameCycle;
				if (var0.movementFrame < var11.frameIds.length && var0.movementFrameCycle > var11.frameLengths[var0.movementFrame]) {
					var0.movementFrameCycle = 1;
					++var0.movementFrame;
					WorldMapSection0.addSequenceSoundEffect(var11, var0.movementFrame, var0.x, var0.y);
				}

				if (var0.movementFrame >= var11.frameIds.length) {
					var0.movementFrameCycle = 0;
					var0.movementFrame = 0;
					WorldMapSection0.addSequenceSoundEffect(var11, var0.movementFrame, var0.x, var0.y);
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field989) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var2 = MusicPatch.getSpotAnimationDefinition(var0.spotAnimation).sequence;
			if (var2 != -1) {
				SequenceDefinition var12 = GrandExchangeEvent.getSequenceDefinition(var2);
				if (var12 != null && var12.frameIds != null) {
					++var0.spotAnimationFrameCycle;
					if (var0.spotAnimationFrame < var12.frameIds.length && var0.spotAnimationFrameCycle > var12.frameLengths[var0.spotAnimationFrame]) {
						var0.spotAnimationFrameCycle = 1;
						++var0.spotAnimationFrame;
						WorldMapSection0.addSequenceSoundEffect(var12, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var12.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var12.frameIds.length)) {
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
			var11 = GrandExchangeEvent.getSequenceDefinition(var0.sequence);
			if (var11.field3525 == 1 && var0.field1008 > 0 && var0.field995 <= Client.cycle && var0.field996 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var11 = GrandExchangeEvent.getSequenceDefinition(var0.sequence);
			if (var11 != null && var11.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var11.frameIds.length && var0.sequenceFrameCycle > var11.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					WorldMapSection0.addSequenceSoundEffect(var11, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var11.frameIds.length) {
					var0.sequenceFrame -= var11.frameCount;
					++var0.field985;
					if (var0.field985 >= var11.field3535) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var11.frameIds.length) {
						WorldMapSection0.addSequenceSoundEffect(var11, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.field967 = var11.field3526;
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1674693758"
	)
	static final void method4530() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field776[++Client.field775 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field859[++Client.field697 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method1974(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field859[++Client.field697 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method1974(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method1974(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field859[++Client.field697 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field776[++Client.field775 - 1] = var3;
						}
					}
				}
			}

		}
	}
}
