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
   @Export("__g")
   String __g;

   FontName(String var1) {
      this.__g = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIZII)J",
      garbageValue = "1039369805"
   )
   public static long method5637(int var0, int var1, int var2, boolean var3, int var4) {
      long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
      if(var3) {
         var5 |= 65536L;
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1587423260"
   )
   static void method5636() {
      Login.__cu_bk = false;
      Login.__cu_g.drawAt(Login.__cu_q, 0);
      Fonts.__kz_l.drawAt(Login.__cu_q + 382, 0);
      WorldMapSectionType.__h_e.__q_496(Login.__cu_q + 382 - WorldMapSectionType.__h_e.subWidth / 2, 18);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-871458249"
   )
   static final void method5638(String var0, int var1) {
      PacketBufferNode var2 = Interpreter.method1915(ClientPacket.__gs_bw, Client.packetWriter.isaacCipher);
      var2.packetBuffer.writeByte(WorldMapRegion.method550(var0) + 1);
      var2.packetBuffer.writeStringCp1252NullTerminated(var0);
      var2.packetBuffer.writeByte(var1);
      Client.packetWriter.__q_167(var2);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-1336396061"
   )
   static int method5639(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(WorldMapArea.friendSystem.__g == 0) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -2;
         } else if(WorldMapArea.friendSystem.__g == 1) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
         } else {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.friendsList.size();
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            if(WorldMapArea.friendSystem.__m_151() && var3 >= 0 && var3 < WorldMapArea.friendSystem.friendsList.size()) {
               Friend var6 = (Friend)WorldMapArea.friendSystem.friendsList.get(var3);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.name();
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.previousName();
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            if(WorldMapArea.friendSystem.__m_151() && var3 >= 0 && var3 < WorldMapArea.friendSystem.friendsList.size()) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ((Buddy)WorldMapArea.friendSystem.friendsList.get(var3)).world0;
            } else {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            if(WorldMapArea.friendSystem.__m_151() && var3 >= 0 && var3 < WorldMapArea.friendSystem.friendsList.size()) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ((Buddy)WorldMapArea.friendSystem.friendsList.get(var3)).rank;
            } else {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var4;
            if(var0 == 3604) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               int var8 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               method5638(var4, var8);
               return 1;
            } else if(var0 == 3605) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.__l_157(var4);
               return 1;
            } else if(var0 == 3606) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.removeFriend(var4);
               return 1;
            } else if(var0 == 3607) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.__x_159(var4);
               return 1;
            } else if(var0 == 3608) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               WorldMapArea.friendSystem.removeIgnore(var4);
               return 1;
            } else if(var0 == 3609) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var4 = NPCDefinition.method5161(var4);
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.isFriended(new Username(var4, KeyHandler.loginType), false)?1:0;
               return 1;
            } else if(var0 == 3611) {
               if(PacketWriter.clanChat != null) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = PacketWriter.clanChat.name;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3612) {
               if(PacketWriter.clanChat != null) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = PacketWriter.clanChat.size();
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3613) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size()) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = PacketWriter.clanChat.get(var3).username().getName();
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3614) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size()) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ((Buddy)PacketWriter.clanChat.get(var3)).world();
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3615) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size()) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = ((Buddy)PacketWriter.clanChat.get(var3)).rank;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3616) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = PacketWriter.clanChat != null?PacketWriter.clanChat.__k:0;
               return 1;
            } else if(var0 == 3617) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               IndexStoreActionHandler.method4655(var4);
               return 1;
            } else if(var0 == 3618) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = PacketWriter.clanChat != null?PacketWriter.clanChat.rank:0;
               return 1;
            } else if(var0 == 3619) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               class31.method574(var4);
               return 1;
            } else if(var0 == 3620) {
               class12.method158();
               return 1;
            } else if(var0 == 3621) {
               if(!WorldMapArea.friendSystem.__m_151()) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.ignoreList.size();
               }

               return 1;
            } else if(var0 == 3622) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(WorldMapArea.friendSystem.__m_151() && var3 >= 0 && var3 < WorldMapArea.friendSystem.ignoreList.size()) {
                  Ignored var7 = (Ignored)WorldMapArea.friendSystem.ignoreList.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.name();
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.previousName();
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3623) {
               var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var4 = NPCDefinition.method5161(var4);
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapArea.friendSystem.isIgnored(new Username(var4, KeyHandler.loginType))?1:0;
               return 1;
            } else if(var0 == 3624) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size() && PacketWriter.clanChat.get(var3).username().__equals_466(Canvas.localPlayer.username)) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3625) {
               if(PacketWriter.clanChat != null && PacketWriter.clanChat.owner != null) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = PacketWriter.clanChat.owner;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3626) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size() && ((ClanMate)PacketWriter.clanChat.get(var3)).isFriend()) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 != 3627) {
               if(var0 == 3628) {
                  WorldMapArea.friendSystem.friendsList.removeComparator();
                  return 1;
               } else {
                  boolean var5;
                  if(var0 == 3629) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator1(var5));
                     return 1;
                  } else if(var0 == 3630) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator2(var5));
                     return 1;
                  } else if(var0 == 3631) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator3(var5));
                     return 1;
                  } else if(var0 == 3632) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator4(var5));
                     return 1;
                  } else if(var0 == 3633) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator5(var5));
                     return 1;
                  } else if(var0 == 3634) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator6(var5));
                     return 1;
                  } else if(var0 == 3635) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator7(var5));
                     return 1;
                  } else if(var0 == 3636) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator8(var5));
                     return 1;
                  } else if(var0 == 3637) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator9(var5));
                     return 1;
                  } else if(var0 == 3638) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new UserComparator10(var5));
                     return 1;
                  } else if(var0 == 3639) {
                     WorldMapArea.friendSystem.friendsList.sort();
                     return 1;
                  } else if(var0 == 3640) {
                     WorldMapArea.friendSystem.ignoreList.removeComparator();
                     return 1;
                  } else if(var0 == 3641) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.ignoreList.addComparator(new UserComparator1(var5));
                     return 1;
                  } else if(var0 == 3642) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.ignoreList.addComparator(new UserComparator2(var5));
                     return 1;
                  } else if(var0 == 3643) {
                     WorldMapArea.friendSystem.ignoreList.sort();
                     return 1;
                  } else if(var0 == 3644) {
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.removeComparator();
                     }

                     return 1;
                  } else if(var0 == 3645) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator1(var5));
                     }

                     return 1;
                  } else if(var0 == 3646) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator2(var5));
                     }

                     return 1;
                  } else if(var0 == 3647) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator3(var5));
                     }

                     return 1;
                  } else if(var0 == 3648) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator4(var5));
                     }

                     return 1;
                  } else if(var0 == 3649) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator5(var5));
                     }

                     return 1;
                  } else if(var0 == 3650) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator6(var5));
                     }

                     return 1;
                  } else if(var0 == 3651) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator7(var5));
                     }

                     return 1;
                  } else if(var0 == 3652) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator8(var5));
                     }

                     return 1;
                  } else if(var0 == 3653) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator9(var5));
                     }

                     return 1;
                  } else if(var0 == 3654) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new UserComparator10(var5));
                     }

                     return 1;
                  } else if(var0 == 3655) {
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.sort();
                     }

                     return 1;
                  } else if(var0 == 3656) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     WorldMapArea.friendSystem.friendsList.addComparator(new class157(var5));
                     return 1;
                  } else if(var0 == 3657) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                     if(PacketWriter.clanChat != null) {
                        PacketWriter.clanChat.addComparator(new class157(var5));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               if(PacketWriter.clanChat != null && var3 < PacketWriter.clanChat.size() && ((ClanMate)PacketWriter.clanChat.get(var3)).isIgnored()) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
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
      class72.method1780();
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.__jh_o.clear();
      UserComparator3.method3379();
      VarbitDefinition.VarbitDefinition_cached.clear();
      VarpDefinition.VarpDefinition_cached.clear();
      GrandExchangeEvents.method69();
      Buffer.method3915();
      StructDefinition.__jq_f.clear();
      InvDefinition.method4754();
      Projectile.method2089();
      PlayerAppearance.PlayerAppearance_cachedModels.clear();
      class157.method3382();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
      Script.Script_cached.clear();
      AbstractIndexCache.indexCache0.__b_400();
      Skeleton.indexCache1.__b_400();
      WorldMapIcon1.indexCache3.__b_400();
      class25.indexCache4.__b_400();
      SecureRandomFuture.indexCache5.__b_400();
      UserComparator3.indexCache6.__b_400();
      class40.indexCache7.__b_400();
      WorldMapSection3.indexCache8.__b_400();
      class238.indexCache9.__b_400();
      class16.indexCache10.__b_400();
      Login.indexCache11.__b_400();
      Formatting.indexCache12.__b_400();
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2003105831"
   )
   @Export("setViewportShape")
   static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      int var6;
      if(var5 < 0) {
         var6 = Client.__client_rw;
      } else if(var5 >= 100) {
         var6 = Client.__client_rm;
      } else {
         var6 = (Client.__client_rm - Client.__client_rw) * var5 / 100 + Client.__client_rw;
      }

      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if(var7 < Client.__client_rs) {
         var10 = Client.__client_rs;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if(var6 > Client.__client_ri) {
            var6 = Client.__client_ri;
            var8 = var3 * var6 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.__client_rp) {
         var10 = Client.__client_rp;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if(var6 < Client.__client_rv) {
            var6 = Client.__client_rv;
            var8 = var10 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      Client.viewportZoom = var3 * var6 / 334;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
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
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
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
