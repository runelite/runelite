import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("q")
   boolean field839;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 500626991
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1896222087
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field839 = false;
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "591611095"
   )
   static void method1088() {
      if(Client.field1043 >= 0 && Client.cachedPlayers[Client.field1043] != null) {
         class29.method249(Client.cachedPlayers[Client.field1043], false);
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "67"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.method3258();
         int var2 = Client.secretPacketBuffer2.method3258();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class35.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class35.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class15.mapRegions = new int[var3];
         WorldMapType3.field400 = new int[var3];
         class2.landRegionFielIds = new int[var3];
         class36.field519 = new byte[var3][];
         ScriptEvent.field856 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class15.mapRegions[var3] = var7;
                  WorldMapType3.field400[var3] = class18.indexMaps.getFile("m" + var5 + "_" + var6);
                  class2.landRegionFielIds[var3] = class18.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         GroundObject.method2539(var1, var2, true);
      } else {
         var1 = Client.secretPacketBuffer2.method3259();
         boolean var14 = Client.secretPacketBuffer2.method3250() == 1;
         var3 = Client.secretPacketBuffer2.method3258();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field988[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field988[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         class35.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class35.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         class15.mapRegions = new int[var4];
         WorldMapType3.field400 = new int[var4];
         class2.landRegionFielIds = new int[var4];
         class36.field519 = new byte[var4][];
         ScriptEvent.field856 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field988[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(class15.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class15.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        WorldMapType3.field400[var4] = class18.indexMaps.getFile("m" + var12 + "_" + var13);
                        class2.landRegionFielIds[var4] = class18.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         GroundObject.method2539(var3, var1, !var14);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkp;I)Ljava/lang/String;",
      garbageValue = "-426262579"
   )
   public static String method1087(CharSequence var0, class290 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3874) {
               case 1:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var13 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else {
                     boolean var9 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                     if(var9) {
                        var8 = true;
                     } else {
                        char[] var10 = class267.field3667;
                        int var11 = 0;

                        label105:
                        while(true) {
                           char var12;
                           if(var11 >= var10.length) {
                              var10 = class267.field3668;

                              for(var11 = 0; var11 < var10.length; ++var11) {
                                 var12 = var10[var11];
                                 if(var12 == var7) {
                                    var8 = true;
                                    break label105;
                                 }
                              }

                              var8 = false;
                              break;
                           }

                           var12 = var10[var11];
                           if(var12 == var7) {
                              var8 = true;
                              break;
                           }

                           ++var11;
                        }
                     }
                  }

                  if(var8) {
                     char var16 = class254.method4597(var7);
                     if(var16 != 0) {
                        var13.append(var16);
                     }
                  }
               }

               if(var13.length() == 0) {
                  return null;
               }

               return var13.toString();
            }
         }

         return null;
      }
   }
}
