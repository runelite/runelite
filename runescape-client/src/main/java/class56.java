import java.applet.Applet;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("bv")
public class class56 {
   @ObfuscatedName("i")
   static Applet field697;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static class233 field695;
   @ObfuscatedName("j")
   static String field692;
   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field696;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 833248891
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   static {
      field697 = null;
      field692 = null;
   }

   @ObfuscatedName("i")
   static final int method864(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (1.0D + var2) * var4;
         } else {
            var12 = var4 + var2 - var4 * var2;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + 6.0D * (var12 - var14) * var16;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = 6.0D * (0.6666666666666666D - var16) * (var12 - var14) + var14;
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = (var12 - var14) * 6.0D * var0 + var14;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = (var12 - var14) * (0.6666666666666666D - var0) * 6.0D + var14;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var14 + var20 * (var12 - var14) * 6.0D;
         } else if(2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(256.0D * var8);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)Z",
      garbageValue = "114"
   )
   static final boolean method866(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class133.field2001 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class133.field2001 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class133.field2002 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class133.field2002 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lff;ZI)V",
      garbageValue = "-2012979739"
   )
   public static void method868(RSSocket var0, boolean var1) {
      if(class294.field3904 != null) {
         try {
            class294.field3904.close();
         } catch (Exception var6) {
            ;
         }

         class294.field3904 = null;
      }

      class294.field3904 = var0;
      class18.sendConInfo(var1);
      class239.field3261.offset = 0;
      class29.currentRequest = null;
      BuildType.field3190 = null;
      class239.field3260 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class239.field3273.method3628();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class239.field3263.method3628();
               if(var2 == null) {
                  if(class239.field3269 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class239.field3269);
                        var7.putShort(0);
                        class294.field3904.queueForWrite(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class294.field3904.close();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class239.field3274;
                        class294.field3904 = null;
                     }
                  }

                  class239.field3265 = 0;
                  class239.field3255 = class45.currentTimeMs();
                  return;
               }

               class239.field3258.setHead(var2);
               class239.field3264.put(var2, var2.hash);
               ++class239.field3254;
               --class239.field3266;
            }
         }

         class239.field3256.put(var2, var2.hash);
         ++class239.field3257;
         --class239.field3259;
      }
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-173539882"
   )
   static final void method854(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class27.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = ScriptState.region.method2896(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = ScriptState.region.method2739(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = ScriptState.region.method2875(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = ScriptState.region.method2762(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = ScriptState.region.method2741(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               ScriptState.region.method2729(var0, var2, var3);
               var12 = GameObject.getObjectDefinition(var13);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.field3452);
               }
            }

            if(var1 == 1) {
               ScriptState.region.method2883(var0, var2, var3);
            }

            if(var1 == 2) {
               ScriptState.region.method2890(var0, var2, var3);
               var12 = GameObject.getObjectDefinition(var13);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field3452);
               }
            }

            if(var1 == 3) {
               ScriptState.region.method2732(var0, var2, var3);
               var12 = GameObject.getObjectDefinition(var13);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Player.method1167(var0, var11, var2, var3, var4, var5, var6, ScriptState.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-2043388445"
   )
   static int method867(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
      } else {
         var3 = var2?class31.field452:class23.field366;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class82.intStack[--Ignore.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4040(var4, class82.scriptStringStack[--class169.scriptStringStackSize]);
            return 1;
         } else {
            --class169.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         Ignore.intStackSize -= 2;
         var4 = class82.intStack[Ignore.intStackSize];
         int var5 = class82.intStack[Ignore.intStackSize + 1];
         var3.dragParent = Varcs.method1849(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2715 = class82.intStack[--Ignore.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2659 = class82.intStack[--Ignore.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2649 = class82.intStack[--Ignore.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class82.scriptStringStack[--class169.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class82.scriptStringStack[--class169.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1805651369"
   )
   static final void method858(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_144);
         Client.secretPacketBuffer1.putByte(ClanMember.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "38"
   )
   static final void method865(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class227.getTileHeight(var0, var1, class27.plane) - var2;
         var0 -= class82.cameraX;
         var3 -= Ignore.cameraZ;
         var1 -= class158.cameraY;
         int var4 = Graphics3D.SINE[Friend.cameraPitch];
         int var5 = Graphics3D.COSINE[Friend.cameraPitch];
         int var6 = Graphics3D.SINE[Ignore.cameraYaw];
         int var7 = Graphics3D.COSINE[Ignore.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenY = Client.viewportHeight / 2 + var0 * Client.scale / var1;
            Client.screenX = Client.viewportWidth / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "-41"
   )
   public static int method869(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class239.field3259 + class239.field3257;
      return var3;
   }
}
