import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("LoginPacket")
public class LoginPacket implements class167 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final LoginPacket field2261;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   static final LoginPacket field2259;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final LoginPacket field2260;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   public static final LoginPacket field2258;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lfq;"
   )
   static final LoginPacket[] field2263;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static JagexGame field2265;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -748028369
   )
   @Export("id")
   public final int id;

   static {
      field2261 = new LoginPacket(14, 0);
      field2259 = new LoginPacket(15, 4);
      field2260 = new LoginPacket(16, -2);
      field2258 = new LoginPacket(18, -2);
      field2263 = new LoginPacket[32];
      LoginPacket[] var0 = class25.method466();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2263[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1942135912"
   )
   public static String method3466(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class294.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "749040427"
   )
   static int method3465(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(CacheFile.friendManager.field994 == 0) {
            class69.intStack[++class45.intStackSize - 1] = -2;
         } else if(CacheFile.friendManager.field994 == 1) {
            class69.intStack[++class45.intStackSize - 1] = -1;
         } else {
            class69.intStack[++class45.intStackSize - 1] = CacheFile.friendManager.friendContainer.getCount();
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class69.intStack[--class45.intStackSize];
            if(CacheFile.friendManager.method1663() && var3 >= 0 && var3 < CacheFile.friendManager.friendContainer.getCount()) {
               Friend var9 = (Friend)CacheFile.friendManager.friendContainer.get(var3);
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var9.getName();
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var9.getPrevName();
            } else {
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class69.intStack[--class45.intStackSize];
            if(CacheFile.friendManager.method1663() && var3 >= 0 && var3 < CacheFile.friendManager.friendContainer.getCount()) {
               class69.intStack[++class45.intStackSize - 1] = ((ChatPlayer)CacheFile.friendManager.friendContainer.get(var3)).world;
            } else {
               class69.intStack[++class45.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class69.intStack[--class45.intStackSize];
            if(CacheFile.friendManager.method1663() && var3 >= 0 && var3 < CacheFile.friendManager.friendContainer.getCount()) {
               class69.intStack[++class45.intStackSize - 1] = ((ChatPlayer)CacheFile.friendManager.friendContainer.get(var3)).rank;
            } else {
               class69.intStack[++class45.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var5;
            if(var0 == 3604) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               int var6 = class69.intStack[--class45.intStackSize];
               class9.method95(var5, var6);
               return 1;
            } else if(var0 == 3605) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               CacheFile.friendManager.addToFriendsList(var5);
               return 1;
            } else if(var0 == 3606) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               CacheFile.friendManager.removeFriend(var5);
               return 1;
            } else if(var0 == 3607) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               CacheFile.friendManager.addToIgnoreList(var5);
               return 1;
            } else if(var0 == 3608) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               CacheFile.friendManager.method1675(var5);
               return 1;
            } else if(var0 == 3609) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               var5 = class9.method97(var5);
               class69.intStack[++class45.intStackSize - 1] = CacheFile.friendManager.isFriended(new Name(var5, WorldMapDecoration.loginType), false)?1:0;
               return 1;
            } else if(var0 == 3611) {
               if(WorldComparator.clanMemberManager != null) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = WorldComparator.clanMemberManager.field3667;
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3612) {
               if(WorldComparator.clanMemberManager != null) {
                  class69.intStack[++class45.intStackSize - 1] = WorldComparator.clanMemberManager.getCount();
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3613) {
               var3 = class69.intStack[--class45.intStackSize];
               if(WorldComparator.clanMemberManager != null && var3 < WorldComparator.clanMemberManager.getCount()) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = WorldComparator.clanMemberManager.get(var3).getRsName().getName();
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3614) {
               var3 = class69.intStack[--class45.intStackSize];
               if(WorldComparator.clanMemberManager != null && var3 < WorldComparator.clanMemberManager.getCount()) {
                  class69.intStack[++class45.intStackSize - 1] = ((ChatPlayer)WorldComparator.clanMemberManager.get(var3)).method5433();
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3615) {
               var3 = class69.intStack[--class45.intStackSize];
               if(WorldComparator.clanMemberManager != null && var3 < WorldComparator.clanMemberManager.getCount()) {
                  class69.intStack[++class45.intStackSize - 1] = ((ChatPlayer)WorldComparator.clanMemberManager.get(var3)).rank;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3616) {
               class69.intStack[++class45.intStackSize - 1] = WorldComparator.clanMemberManager != null?WorldComparator.clanMemberManager.field3674:0;
               return 1;
            } else if(var0 == 3617) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               if(WorldComparator.clanMemberManager != null) {
                  PacketNode var8 = DecorativeObject.method3115(ClientPacket.field2255, Client.field739.field1250);
                  var8.packetBuffer.putByte(Size.getLength(var5));
                  var8.packetBuffer.putString(var5);
                  Client.field739.method2019(var8);
               }

               return 1;
            } else if(var0 == 3618) {
               class69.intStack[++class45.intStackSize - 1] = WorldComparator.clanMemberManager != null?WorldComparator.clanMemberManager.field3671:0;
               return 1;
            } else if(var0 == 3619) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               class34.method633(var5);
               return 1;
            } else if(var0 == 3620) {
               PacketNode var10 = DecorativeObject.method3115(ClientPacket.field2176, Client.field739.field1250);
               var10.packetBuffer.putByte(0);
               Client.field739.method2019(var10);
               return 1;
            } else if(var0 == 3621) {
               if(!CacheFile.friendManager.method1663()) {
                  class69.intStack[++class45.intStackSize - 1] = -1;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = CacheFile.friendManager.ignoreContainer.getCount();
               }

               return 1;
            } else if(var0 == 3622) {
               var3 = class69.intStack[--class45.intStackSize];
               if(CacheFile.friendManager.method1663() && var3 >= 0 && var3 < CacheFile.friendManager.ignoreContainer.getCount()) {
                  Ignore var4 = (Ignore)CacheFile.friendManager.ignoreContainer.get(var3);
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var4.getName();
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var4.getPrevName();
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3623) {
               var5 = class69.scriptStringStack[--class83.scriptStringStackSize];
               var5 = class9.method97(var5);
               class69.intStack[++class45.intStackSize - 1] = CacheFile.friendManager.isIgnored(new Name(var5, WorldMapDecoration.loginType))?1:0;
               return 1;
            } else if(var0 == 3624) {
               var3 = class69.intStack[--class45.intStackSize];
               if(WorldComparator.clanMemberManager != null && var3 < WorldComparator.clanMemberManager.getCount() && WorldComparator.clanMemberManager.get(var3).getRsName().equals(MilliTimer.localPlayer.name)) {
                  class69.intStack[++class45.intStackSize - 1] = 1;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3625) {
               if(WorldComparator.clanMemberManager != null && WorldComparator.clanMemberManager.field3669 != null) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = WorldComparator.clanMemberManager.field3669;
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3626) {
               var3 = class69.intStack[--class45.intStackSize];
               if(WorldComparator.clanMemberManager != null && var3 < WorldComparator.clanMemberManager.getCount() && ((ClanMember)WorldComparator.clanMemberManager.get(var3)).method5277()) {
                  class69.intStack[++class45.intStackSize - 1] = 1;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 != 3627) {
               if(var0 == 3628) {
                  CacheFile.friendManager.friendContainer.method5361();
                  return 1;
               } else {
                  boolean var7;
                  if(var0 == 3629) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class308(var7));
                     return 1;
                  } else if(var0 == 3630) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class309(var7));
                     return 1;
                  } else if(var0 == 3631) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class143(var7));
                     return 1;
                  } else if(var0 == 3632) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class137(var7));
                     return 1;
                  } else if(var0 == 3633) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class142(var7));
                     return 1;
                  } else if(var0 == 3634) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class145(var7));
                     return 1;
                  } else if(var0 == 3635) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class141(var7));
                     return 1;
                  } else if(var0 == 3636) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class139(var7));
                     return 1;
                  } else if(var0 == 3637) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class138(var7));
                     return 1;
                  } else if(var0 == 3638) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class140(var7));
                     return 1;
                  } else if(var0 == 3639) {
                     CacheFile.friendManager.friendContainer.method5383();
                     return 1;
                  } else if(var0 == 3640) {
                     CacheFile.friendManager.ignoreContainer.method5361();
                     return 1;
                  } else if(var0 == 3641) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.ignoreContainer.method5381(new class308(var7));
                     return 1;
                  } else if(var0 == 3642) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.ignoreContainer.method5381(new class309(var7));
                     return 1;
                  } else if(var0 == 3643) {
                     CacheFile.friendManager.ignoreContainer.method5383();
                     return 1;
                  } else if(var0 == 3644) {
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5361();
                     }

                     return 1;
                  } else if(var0 == 3645) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class308(var7));
                     }

                     return 1;
                  } else if(var0 == 3646) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class309(var7));
                     }

                     return 1;
                  } else if(var0 == 3647) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class143(var7));
                     }

                     return 1;
                  } else if(var0 == 3648) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class137(var7));
                     }

                     return 1;
                  } else if(var0 == 3649) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class142(var7));
                     }

                     return 1;
                  } else if(var0 == 3650) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class145(var7));
                     }

                     return 1;
                  } else if(var0 == 3651) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class141(var7));
                     }

                     return 1;
                  } else if(var0 == 3652) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class139(var7));
                     }

                     return 1;
                  } else if(var0 == 3653) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class138(var7));
                     }

                     return 1;
                  } else if(var0 == 3654) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class140(var7));
                     }

                     return 1;
                  } else if(var0 == 3655) {
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5383();
                     }

                     return 1;
                  } else if(var0 == 3656) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     CacheFile.friendManager.friendContainer.method5381(new class144(var7));
                     return 1;
                  } else if(var0 == 3657) {
                     var7 = class69.intStack[--class45.intStackSize] == 1;
                     if(WorldComparator.clanMemberManager != null) {
                        WorldComparator.clanMemberManager.method5381(new class144(var7));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = class69.intStack[--class45.intStackSize];
               if(WorldComparator.clanMemberManager != null && var3 < WorldComparator.clanMemberManager.getCount() && ((ClanMember)WorldComparator.clanMemberManager.get(var3)).method5280()) {
                  class69.intStack[++class45.intStackSize - 1] = 1;
               } else {
                  class69.intStack[++class45.intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }
}
