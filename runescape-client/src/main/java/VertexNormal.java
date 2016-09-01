import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1065861895
   )
   int field1678;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1007481743
   )
   int field1679;
   @ObfuscatedName("co")
   static class227 field1680;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1691497391
   )
   int field1681;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2044690233
   )
   int field1684;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -1622876377
   )
   static int field1685;

   VertexNormal(VertexNormal var1) {
      this.field1684 = var1.field1684;
      this.field1679 = var1.field1679;
      this.field1678 = var1.field1678;
      this.field1681 = var1.field1681;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)V",
      garbageValue = "106"
   )
   static final void method2251(class125 var0) {
      var0.method2824();
      int var1 = Client.localInteractingIndex;
      Player var2 = class48.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field48 = var1;
      int var3 = var0.method2827(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class28.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method27() << 6);
      var2.pathY[0] = var6 - class159.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method27() << 6);
      FrameMap.plane = var2.field47 = var4;
      if(class34.field759[var1] != null) {
         var2.method19(class34.field759[var1]);
      }

      class34.field760 = 0;
      class34.field755[++class34.field760 - 1] = var1;
      class34.field757[var1] = 0;
      class34.field764 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method2827(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field761[var7] = var11 + (var10 << 14) + (var9 << 28);
            class34.field765[var7] = 0;
            class34.field766[var7] = -1;
            class34.field763[++class34.field764 - 1] = var7;
            class34.field757[var7] = 0;
         }
      }

      var0.method2822();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1196519262"
   )
   public static File method2252(String var0) {
      if(!class138.field2131) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2132.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class138.field2129, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class138.field2132.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "26"
   )
   public static boolean method2253(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label93: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label93;
               }

               if(var7 == 43) {
                  break label93;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = 10 * var4 + var9;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[BLclass137;I)V",
      garbageValue = "333979618"
   )
   static void method2254(int var0, byte[] var1, class137 var2) {
      class172 var3 = new class172();
      var3.field2764 = 0;
      var3.hash = (long)var0;
      var3.field2763 = var1;
      var3.field2762 = var2;
      Deque var4 = class173.field2769;
      synchronized(class173.field2769) {
         class173.field2769.method3844(var3);
      }

      class54.method1097();
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1749570825"
   )
   static final void method2255(Widget var0, int var1, int var2) {
      if(Client.field494 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var7 = class132.method2880(var0);
            int var10 = var7 >> 17 & 7;
            int var8 = var10;
            Widget var4;
            int var9;
            if(var10 == 0) {
               var4 = null;
            } else {
               var9 = 0;

               while(true) {
                  if(var9 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = World.method628(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var9;
               }
            }

            Widget var6 = var4;
            if(var4 == null) {
               var6 = var0.parent;
            }

            if(var6 != null) {
               Client.field494 = var0;
               var5 = var0;
               var7 = class132.method2880(var0);
               var10 = var7 >> 17 & 7;
               var8 = var10;
               if(var10 == 0) {
                  var4 = null;
               } else {
                  var9 = 0;

                  while(true) {
                     if(var9 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = World.method628(var5.parentId);
                     if(null == var5) {
                        var4 = null;
                        break;
                     }

                     ++var9;
                  }
               }

               var6 = var4;
               if(null == var4) {
                  var6 = var0.parent;
               }

               Client.field453 = var6;
               Client.field454 = var1;
               Client.field455 = var2;
               class14.field211 = 0;
               Client.field548 = false;
               if(Client.menuOptionCount > 0) {
                  int var11 = Client.menuOptionCount - 1;
                  class59.field1242 = new class32();
                  class59.field1242.field715 = Client.menuActionParams0[var11];
                  class59.field1242.field713 = Client.menuActionParams1[var11];
                  class59.field1242.field714 = Client.menuTypes[var11];
                  class59.field1242.field717 = Client.menuIdentifiers[var11];
                  class59.field1242.field716 = Client.menuOptions[var11];
               }

               return;
            }
         }

      }
   }

   VertexNormal() {
   }
}
