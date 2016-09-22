import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class75 implements Runnable {
   @ObfuscatedName("v")
   volatile boolean field1419 = false;
   @ObfuscatedName("a")
   class139 field1421;
   @ObfuscatedName("r")
   volatile boolean field1422 = false;
   @ObfuscatedName("d")
   volatile class59[] field1424 = new class59[2];

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-364141998"
   )
   static final void method1621(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.field2815 || !class11.method154(var3))) {
            if(var3.type == 0) {
               if(!var3.field2815 && class11.method154(var3) && class40.field906 != var3) {
                  continue;
               }

               method1621(var0, var3.id);
               if(var3.children != null) {
                  method1621(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method3817((long)var3.id);
               if(null != var7) {
                  BufferProvider.method1731(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2938 != -1 || var3.field2864 != -1) {
                  boolean var4 = class49.method1030(var3);
                  if(var4) {
                     var5 = var3.field2864;
                  } else {
                     var5 = var3.field2938;
                  }

                  if(var5 != -1) {
                     Sequence var6 = Friend.getAnimation(var5);

                     for(var3.field2825 += Client.field358; var3.field2825 > var6.field1015[var3.field2862]; class53.method1101(var3)) {
                        var3.field2825 -= var6.field1015[var3.field2862];
                        ++var3.field2862;
                        if(var3.field2862 >= var6.field1009.length) {
                           var3.field2862 -= var6.field1014;
                           if(var3.field2862 < 0 || var3.field2862 >= var6.field1009.length) {
                              var3.field2862 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2872 != 0 && !var3.field2815) {
                  int var8 = var3.field2872 >> 16;
                  var5 = var3.field2872 << 16 >> 16;
                  var8 *= Client.field358;
                  var5 *= Client.field358;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class53.method1101(var3);
               }
            }
         }
      }

   }

   public void run() {
      this.field1422 = true;

      try {
         while(!this.field1419) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class59 var2 = this.field1424[var1];
               if(null != var2) {
                  var2.method1235();
               }
            }

            Item.method681(10L);
            class129.method2857(this.field1421, (Object)null);
         }
      } catch (Exception var7) {
         class128.method2843((String)null, var7);
      } finally {
         this.field1422 = false;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)Z",
      garbageValue = "2"
   )
   static boolean method1622(class125 var0, int var1) {
      int var2 = var0.method2792(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2792(1) != 0) {
            method1622(var0, var1);
         }

         var3 = var0.method2792(6);
         var4 = var0.method2792(6);
         boolean var12 = var0.method2792(1) == 1;
         if(var12) {
            class34.field787[++class34.field786 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field54 = var1;
            if(class34.field778[var1] != null) {
               var6.method14(class34.field778[var1]);
            }

            var6.field891 = class34.field788[var1];
            var6.interacting = class34.field785[var1];
            var7 = class34.field794[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field896[0] = class34.field777[var1];
            var6.field40 = (byte)var8;
            var6.method20(var3 + (var9 << 6) - class9.baseX, var4 + (var10 << 6) - KitDefinition.baseY);
            var6.field55 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2792(2);
         var4 = class34.field794[var1];
         class34.field794[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2792(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class34.field794[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field794[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method2792(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class34.field794[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var11 & 255;
            class34.field794[var1] = (var8 << 28) + (var9 << 14) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "126"
   )
   static void method1624(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class214.field3185, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2513(3);
         var3.method2513(var1 != null?1:0);
         var3.method2521(var0.getPath());
         if(var1 != null) {
            var3.method2521(var1.getPath());
         }

         var2.method4175(var3.payload, 0, var3.offset);
         var2.method4197();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }
}
