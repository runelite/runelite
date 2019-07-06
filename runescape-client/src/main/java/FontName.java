import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("FontName_verdana11")
   public static final FontName FontName_verdana11;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("FontName_verdana13")
   public static final FontName FontName_verdana13;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("FontName_verdana15")
   public static final FontName FontName_verdana15;
   @ObfuscatedName("g")
   String field349;

   FontName(String var1) {
      this.field349 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIZII)J",
      garbageValue = "1039369805"
   )
   @Export("calculateTag")
   public static long calculateTag(int x, int y, int type, boolean isNotInteractable, int identifier) {
      long var5 = (long)((x & 0b1111111) << 0 | (y & 0b1111111) << 7 | (type & 0b11) << 14) | ((long)identifier & 0xffffffffL) << 17;
      if (isNotInteractable) {
         var5 |= 0x10000L;
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1587423260"
   )
   @Export("closeWorldSelect")
   static void closeWorldSelect() {
      Login.worldSelectOpen = false;
      Login.leftTitleSprite.drawAt(Login.xPadding, 0);
      Fonts.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
      WorldMapSectionType.logoSprite.drawAt(Login.xPadding + 382 - WorldMapSectionType.logoSprite.subWidth / 2, 18);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-871458249"
   )
   static final void method5638(String var0, int var1) {
      PacketBufferNode var2 = Interpreter.method1915(ClientPacket.field299, Client.packetWriter.isaacCipher);
      var2.packetBuffer.writeByte(WorldMapRegion.method550(var0) + 1);
      var2.packetBuffer.writeStringCp1252NullTerminated(var0);
      var2.packetBuffer.writeByte(var1);
      Client.packetWriter.method241(var2);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-1336396061"
   )
   static int method5639(int var0, Script var1, boolean var2) {
      if (var0 == 3600) {
         if (WorldMapArea.friendSystem.field357 == 0) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -2;
         } else if (WorldMapArea.friendSystem.field357 == 1) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
         } else {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.friendsList.size();
         }

         return 1;
      } else {
         int var3;
         if (var0 == 3601) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            if (WorldMapArea.friendSystem.method99() && var3 >= 0 && var3 < WorldMapArea.friendSystem.friendsList.size()) {
               Friend var6 = (Friend)WorldMapArea.friendSystem.friendsList.get(var3);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.name();
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.previousName();
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 3602) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            if (WorldMapArea.friendSystem.method99() && var3 >= 0 && var3 < WorldMapArea.friendSystem.friendsList.size()) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ((Buddy)WorldMapArea.friendSystem.friendsList.get(var3)).world0;
            } else {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3603) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            if (WorldMapArea.friendSystem.method99() && var3 >= 0 && var3 < WorldMapArea.friendSystem.friendsList.size()) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ((Buddy)WorldMapArea.friendSystem.friendsList.get(var3)).rank;
            } else {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var4;
            if (var0 == 3604) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               int var8 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               method5638(var4, var8);
               return 1;
            } else if (var0 == 3605) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.method103(var4);
               return 1;
            } else if (var0 == 3606) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.removeFriend(var4);
               return 1;
            } else if (var0 == 3607) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.method105(var4);
               return 1;
            } else if (var0 == 3608) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.removeIgnore(var4);
               return 1;
            } else if (var0 == 3609) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var4 = NPCDefinition.method5161(var4);
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.isFriended(new Username(var4, KeyHandler.loginType), false) ? 1 : 0;
               return 1;
            } else if (var0 == 3611) {
               if (PacketWriter.clanChat != null) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = PacketWriter.clanChat.name;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3612) {
               if (PacketWriter.clanChat != null) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = PacketWriter.clanChat.size();
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3613) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size()) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = PacketWriter.clanChat.get(var3).username().getName();
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3614) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size()) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ((Buddy)PacketWriter.clanChat.get(var3)).world();
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3615) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size()) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = ((Buddy)PacketWriter.clanChat.get(var3)).rank;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3616) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = PacketWriter.clanChat != null ? PacketWriter.clanChat.field96 : 0;
               return 1;
            } else if (var0 == 3617) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               IndexStoreActionHandler.method4655(var4);
               return 1;
            } else if (var0 == 3618) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = PacketWriter.clanChat != null ? PacketWriter.clanChat.rank : 0;
               return 1;
            } else if (var0 == 3619) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               class31.method574(var4);
               return 1;
            } else if (var0 == 3620) {
               class12.method158();
               return 1;
            } else if (var0 == 3621) {
               if (!WorldMapArea.friendSystem.method99()) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.ignoreList.size();
               }

               return 1;
            } else if (var0 == 3622) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (WorldMapArea.friendSystem.method99() && var3 >= 0 && var3 < WorldMapArea.friendSystem.ignoreList.size()) {
                  Ignored var7 = (Ignored)WorldMapArea.friendSystem.ignoreList.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.name();
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.previousName();
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3623) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var4 = NPCDefinition.method5161(var4);
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.isIgnored(new Username(var4, KeyHandler.loginType)) ? 1 : 0;
               return 1;
            } else if (var0 == 3624) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size() && PacketWriter.clanChat.get(var3).username().equals(Canvas.localPlayer.username)) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3625) {
               if (PacketWriter.clanChat != null && PacketWriter.clanChat.owner != null) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = PacketWriter.clanChat.owner;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 3626) {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size() && ((ClanMate)PacketWriter.clanChat.get(var3)).isFriend()) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 != 3627) {
               if (var0 == 3628) {
                  WorldMapArea.friendSystem.friendsList.removeComparator();
                  return 1;
               } else {
                  boolean var5;
                  if (var0 == 3629) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator1(var5));
                     return 1;
                  } else if (var0 == 3630) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator2(var5));
                     return 1;
                  } else if (var0 == 3631) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator3(var5));
                     return 1;
                  } else if (var0 == 3632) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator4(var5));
                     return 1;
                  } else if (var0 == 3633) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator5(var5));
                     return 1;
                  } else if (var0 == 3634) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator6(var5));
                     return 1;
                  } else if (var0 == 3635) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator7(var5));
                     return 1;
                  } else if (var0 == 3636) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator8(var5));
                     return 1;
                  } else if (var0 == 3637) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator9(var5));
                     return 1;
                  } else if (var0 == 3638) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator10(var5));
                     return 1;
                  } else if (var0 == 3639) {
                     WorldMapArea.friendSystem.friendsList.sort();
                     return 1;
                  } else if (var0 == 3640) {
                     WorldMapArea.friendSystem.ignoreList.removeComparator();
                     return 1;
                  } else if (var0 == 3641) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.ignoreList.addComparator(new UserComparator1(var5));
                     return 1;
                  } else if (var0 == 3642) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.ignoreList.addComparator(new UserComparator2(var5));
                     return 1;
                  } else if (var0 == 3643) {
                     WorldMapArea.friendSystem.ignoreList.sort();
                     return 1;
                  } else if (var0 == 3644) {
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.removeComparator();
                     }

                     return 1;
                  } else if (var0 == 3645) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator1(var5));
                     }

                     return 1;
                  } else if (var0 == 3646) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator2(var5));
                     }

                     return 1;
                  } else if (var0 == 3647) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator3(var5));
                     }

                     return 1;
                  } else if (var0 == 3648) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator4(var5));
                     }

                     return 1;
                  } else if (var0 == 3649) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator5(var5));
                     }

                     return 1;
                  } else if (var0 == 3650) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator6(var5));
                     }

                     return 1;
                  } else if (var0 == 3651) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator7(var5));
                     }

                     return 1;
                  } else if (var0 == 3652) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator8(var5));
                     }

                     return 1;
                  } else if (var0 == 3653) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator9(var5));
                     }

                     return 1;
                  } else if (var0 == 3654) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator10(var5));
                     }

                     return 1;
                  } else if (var0 == 3655) {
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.sort();
                     }

                     return 1;
                  } else if (var0 == 3656) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new class157(var5));
                     return 1;
                  } else if (var0 == 3657) {
                     var5 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                     if (PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new class157(var5));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
               if (PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size() && ((ClanMate)PacketWriter.clanChat.get(var3)).isIgnored()) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1831101083"
   )
   static final void method5641() {
      class4.method55();
      Tile.method2867();
      DevicePcmPlayerProvider.method841();
      WorldMapManager.method673();
      WorldMapLabel.method440();
      LoginScreenAnimation.method1780();
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.field775.clear();
      UserComparator3.method3379();
      VarbitDefinition.VarbitDefinition_cached.clear();
      VarpDefinition.VarpDefinition_cached.clear();
      GrandExchangeEvents.method69();
      Buffer.clearHealthbarCaches();
      StructDefinition.field886.clear();
      InvDefinition.method4754();
      Projectile.method2089();
      PlayerAppearance.PlayerAppearance_cachedModels.clear();
      class157.method3382();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
      Script.Script_cached.clear();
      AbstractIndexCache.indexCache0.method8();
      Skeleton.indexCache1.method8();
      WorldMapIcon1.indexCache3.method8();
      WorldMapDecoration.indexCache4.method8();
      SecureRandomFuture.indexCache5.method8();
      UserComparator3.indexCache6.method8();
      class40.indexCache7.method8();
      WorldMapSection3.indexCache8.method8();
      class238.indexCache9.method8();
      class16.indexCache10.method8();
      Login.indexCache11.method8();
      Formatting.indexCache12.method8();
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2003105831"
   )
   @Export("setViewportShape")
   static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
      if (var2 < 1) {
         var2 = 1;
      }

      if (var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      int var6;
      if (var5 < 0) {
         var6 = Client.field130;
      } else if (var5 >= 100) {
         var6 = Client.field131;
      } else {
         var6 = (Client.field131 - Client.field130) * var5 / 100 + Client.field130;
      }

      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if (var7 < Client.field132) {
         var10 = Client.field132;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if (var6 > Client.field134) {
            var6 = Client.field134;
            var8 = var3 * var6 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if (var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if (var7 > Client.field133) {
         var10 = Client.field133;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if (var6 < Client.field135) {
            var6 = Client.field135;
            var8 = var10 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if (var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      Client.viewportZoom = var3 * var6 / 334;
      if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         ScriptEvent.method1183(var2, var3);
      }

      Client.viewportOffsetX = var0;
      Client.viewportOffsetY = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   static final void method5635() {
      for (int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsInClanChat();
      }

   }

   static {
      FontName_plain11 = new FontName("p11_full");
      FontName_plain12 = new FontName("p12_full");
      FontName_bold12 = new FontName("b12_full");
      FontName_verdana11 = new FontName("verdana_11pt_regular");
      FontName_verdana13 = new FontName("verdana_13pt_regular");
      FontName_verdana15 = new FontName("verdana_15pt_regular");
   }
}
