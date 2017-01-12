import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class6 implements Comparator {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 391069051
   )
   static int field52;
   @ObfuscatedName("x")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("dq")
   @Export("region")
   static Region region;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "64"
   )
   int method80(class2 var1, class2 var2) {
      return var1.method18().compareTo(var2.method18());
   }

   public int compare(Object var1, Object var2) {
      return this.method80((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "119"
   )
   static final void method83(class15 var0) {
      if(class148.localPlayer.x >> 7 == Client.flagX && class148.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field888;
      int[] var2 = class45.field892;
      int var3 = var1;
      if(var0 == class15.field172 || class15.field167 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class15.field172 == var0) {
            var5 = class148.localPlayer;
            var6 = class148.localPlayer.field244 << 14;
         } else if(class15.field167 == var0) {
            var5 = Client.cachedPlayers[Client.field412];
            var6 = Client.field412 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class15.field168 == var0 && var2[var4] == Client.field412) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod718() && !var5.field260) {
            var5.field246 = false;
            if((Client.field286 && var1 > 50 || var1 > 200) && class15.field172 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field246 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field249) {
                  var5.field246 = false;
                  var5.field247 = class176.method3243(var5.x, var5.y, class60.plane);
                  region.method1741(class60.plane, var5.x, var5.y, var5.field247, 60, var5, var5.angle, var6, var5.field254, var5.field258, var5.field256, var5.field257);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field387 == Client.field386[var7][var8]) {
                        continue;
                     }

                     Client.field386[var7][var8] = Client.field387;
                  }

                  var5.field247 = class176.method3243(var5.x, var5.y, class60.plane);
                  region.method1686(class60.plane, var5.x, var5.y, var5.field247, 60, var5, var5.angle, var6, var5.field602);
               }
            }
         }
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "387128959"
   )
   static void method87(Widget var0) {
      if(var0.field2317 == Client.field484) {
         Client.field485[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "8"
   )
   public static String method94(CharSequence var0) {
      return CollisionData.method2228('*', var0.length());
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1835856101"
   )
   static final void method95() {
      int var0 = 64 + class22.field237 * 128;
      int var1 = 64 + class10.field107 * 128;
      int var2 = class176.method3243(var0, var1, class60.plane) - class114.field1776;
      if(class36.cameraX < var0) {
         class36.cameraX += class146.field2004 + (var0 - class36.cameraX) * class145.field2000 / 1000;
         if(class36.cameraX > var0) {
            class36.cameraX = var0;
         }
      }

      if(class36.cameraX > var0) {
         class36.cameraX -= class146.field2004 + class145.field2000 * (class36.cameraX - var0) / 1000;
         if(class36.cameraX < var0) {
            class36.cameraX = var0;
         }
      }

      if(class36.cameraZ < var2) {
         class36.cameraZ += class146.field2004 + class145.field2000 * (var2 - class36.cameraZ) / 1000;
         if(class36.cameraZ > var2) {
            class36.cameraZ = var2;
         }
      }

      if(class36.cameraZ > var2) {
         class36.cameraZ -= (class36.cameraZ - var2) * class145.field2000 / 1000 + class146.field2004;
         if(class36.cameraZ < var2) {
            class36.cameraZ = var2;
         }
      }

      if(GroundObject.cameraY < var1) {
         GroundObject.cameraY += class146.field2004 + class145.field2000 * (var1 - GroundObject.cameraY) / 1000;
         if(GroundObject.cameraY > var1) {
            GroundObject.cameraY = var1;
         }
      }

      if(GroundObject.cameraY > var1) {
         GroundObject.cameraY -= class145.field2000 * (GroundObject.cameraY - var1) / 1000 + class146.field2004;
         if(GroundObject.cameraY < var1) {
            GroundObject.cameraY = var1;
         }
      }

      var0 = ChatLineBuffer.field960 * 128 + 64;
      var1 = 64 + class2.field20 * 128;
      var2 = class176.method3243(var0, var1, class60.plane) - class152.field2061;
      int var3 = var0 - class36.cameraX;
      int var4 = var2 - class36.cameraZ;
      int var5 = var1 - GroundObject.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class165.cameraPitch < var7) {
         class165.cameraPitch += class47.field925 * (var7 - class165.cameraPitch) / 1000 + class60.field1079;
         if(class165.cameraPitch > var7) {
            class165.cameraPitch = var7;
         }
      }

      if(class165.cameraPitch > var7) {
         class165.cameraPitch -= class47.field925 * (class165.cameraPitch - var7) / 1000 + class60.field1079;
         if(class165.cameraPitch < var7) {
            class165.cameraPitch = var7;
         }
      }

      int var9 = var8 - XClanMember.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         XClanMember.cameraYaw += class47.field925 * var9 / 1000 + class60.field1079;
         XClanMember.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         XClanMember.cameraYaw -= class60.field1079 + -var9 * class47.field925 / 1000;
         XClanMember.cameraYaw &= 2047;
      }

      int var10 = var8 - XClanMember.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         XClanMember.cameraYaw = var8;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "-75"
   )
   static final void method96(class159 var0) {
      int var1 = 0;
      var0.method3031();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class45.field888; ++var2) {
         var3 = class45.field892[var2];
         if((class45.field885[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class45.field885[var3] = (byte)(class45.field885[var3] | 2);
            } else {
               var4 = var0.method3032(1);
               if(var4 == 0) {
                  var1 = FileOnDisk.method1383(var0);
                  class45.field885[var3] = (byte)(class45.field885[var3] | 2);
               } else {
                  class11.method153(var0, var3);
               }
            }
         }
      }

      var0.method3040();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3031();

         for(var2 = 0; var2 < class45.field888; ++var2) {
            var3 = class45.field892[var2];
            if((class45.field885[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class45.field885[var3] = (byte)(class45.field885[var3] | 2);
               } else {
                  var4 = var0.method3032(1);
                  if(var4 == 0) {
                     var1 = FileOnDisk.method1383(var0);
                     class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                  } else {
                     class11.method153(var0, var3);
                  }
               }
            }
         }

         var0.method3040();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3031();

            for(var2 = 0; var2 < class45.field890; ++var2) {
               var3 = class45.field899[var2];
               if((class45.field885[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                  } else {
                     var4 = var0.method3032(1);
                     if(var4 == 0) {
                        var1 = FileOnDisk.method1383(var0);
                        class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                     } else if(class30.method673(var0, var3)) {
                        class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                     }
                  }
               }
            }

            var0.method3040();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3031();

               for(var2 = 0; var2 < class45.field890; ++var2) {
                  var3 = class45.field899[var2];
                  if((class45.field885[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                     } else {
                        var4 = var0.method3032(1);
                        if(var4 == 0) {
                           var1 = FileOnDisk.method1383(var0);
                           class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                        } else if(class30.method673(var0, var3)) {
                           class45.field885[var3] = (byte)(class45.field885[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3040();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field888 = 0;
                  class45.field890 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class45.field885[var2] = (byte)(class45.field885[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(null != var5) {
                        class45.field892[++class45.field888 - 1] = var2;
                     } else {
                        class45.field899[++class45.field890 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-2103928350"
   )
   static void method97(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class189.method3445(var0, var1.id, var3, var4, var2);
      if(null != var1.children) {
         class189.method3445(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2339((long)var1.id);
      if(var5 != null) {
         XGrandExchangeOffer.method64(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lclass184;",
      garbageValue = "51"
   )
   static class184 method98(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1676) {
         var4 = new class116(var0, class104.field1676, class215.field3160[var0], 1000000);
      }

      return new class184(var4, class7.field60, var0, var1, var2, var3);
   }
}
