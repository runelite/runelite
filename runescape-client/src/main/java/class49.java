import java.awt.Container;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class49 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1899306367
   )
   public int field1072 = 0;
   @ObfuscatedName("t")
   public static NodeCache field1073 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1285233485
   )
   public int field1074;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1870285385
   )
   public int field1076 = 255;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -1504531539
   )
   static int field1077;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 644724175
   )
   public int field1078 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1305381339
   )
   int field1079 = -1;
   @ObfuscatedName("f")
   public static class170 field1080;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1219216493
   )
   int field1081 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1786136117
   )
   public int field1082 = 255;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -59465193
   )
   public int field1083 = 30;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1776762799
   )
   public int field1084 = 70;
   @ObfuscatedName("n")
   public static NodeCache field1086 = new NodeCache(64);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 784427795
   )
   public int field1089 = 1;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "120"
   )
   public void method984(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method985(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-2734"
   )
   void method985(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method2535();
      } else if(var2 == 2) {
         this.field1076 = var1.method2656();
      } else if(var2 == 3) {
         this.field1082 = var1.method2656();
      } else if(var2 == 4) {
         this.field1078 = 0;
      } else if(var2 == 5) {
         this.field1084 = var1.method2535();
      } else if(var2 == 6) {
         var1.method2656();
      } else if(var2 == 7) {
         this.field1081 = var1.method2636();
      } else if(var2 == 8) {
         this.field1079 = var1.method2636();
      } else if(var2 == 11) {
         this.field1078 = var1.method2535();
      } else if(var2 == 14) {
         this.field1083 = var1.method2656();
      } else if(var2 == 15) {
         this.field1072 = var1.method2656();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-324882483"
   )
   public SpritePixels method986() {
      if(this.field1081 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1073.get((long)this.field1081);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method14(class117.field2025, this.field1081, 0);
            if(null != var1) {
               field1073.put(var1, (long)this.field1081);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1468890244"
   )
   public static int method991(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "65280"
   )
   public static int method992(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1779310386"
   )
   public SpritePixels method996() {
      if(this.field1079 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1073.get((long)this.field1079);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method14(class117.field2025, this.field1079, 0);
            if(var1 != null) {
               field1073.put(var1, (long)this.field1079);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1978674009"
   )
   static void method1009() {
      Client var0 = Client.field442;
      synchronized(Client.field442) {
         Container var1 = Client.field442.method3047();
         if(null != var1) {
            Sequence.field1010 = Math.max(var1.getSize().width, Projectile.field125);
            class130.field2099 = Math.max(var1.getSize().height, class116.field2022);
            Insets var2;
            if(CollisionData.field1956 == var1) {
               var2 = CollisionData.field1956.getInsets();
               Sequence.field1010 -= var2.right + var2.left;
               class130.field2099 -= var2.top + var2.bottom;
            }

            if(Sequence.field1010 <= 0) {
               Sequence.field1010 = 1;
            }

            if(class130.field2099 <= 0) {
               class130.field2099 = 1;
            }

            if(class158.method3187() == 1) {
               class153.field2296 = Client.field436;
               class93.field1616 = Client.field495;
            } else {
               class153.field2296 = Math.min(Sequence.field1010, 7680);
               class93.field1616 = Math.min(class130.field2099, 2160);
            }

            GameEngine.field2248 = (Sequence.field1010 - class153.field2296) / 2;
            GameEngine.field2245 = 0;
            GameObject.canvas.setSize(class153.field2296, class93.field1616);
            XClanMember.bufferProvider = class4.method49(class153.field2296, class93.field1616, GameObject.canvas);
            if(CollisionData.field1956 == var1) {
               var2 = CollisionData.field1956.getInsets();
               GameObject.canvas.setLocation(GameEngine.field2248 + var2.left, GameEngine.field2245 + var2.top);
            } else {
               GameObject.canvas.setLocation(GameEngine.field2248, GameEngine.field2245);
            }

            int var6 = class153.field2296;
            int var3 = class93.field1616;
            if(Sequence.field1010 < var6) {
               var6 = Sequence.field1010;
            }

            if(class130.field2099 < var3) {
               var3 = class130.field2099;
            }

            if(class16.field232 != null) {
               try {
                  class135.method2864(Client.field442, "resize", new Object[]{Integer.valueOf(class158.method3187())});
               } catch (Throwable var7) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               class8.method109(Client.widgetRoot, class153.field2296, class93.field1616, true);
            }

            class50.method1030();
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "113369193"
   )
   static void method1010() {
      try {
         File var0 = new File(class152.field2278, "random.dat");
         int var2;
         if(var0.exists()) {
            class152.field2275 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var1 = 0; var1 < class43.field982.length; ++var1) {
               for(var2 = 0; var2 < class75.field1398.length; ++var2) {
                  File var3 = new File(class75.field1398[var2] + class43.field982[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class152.field2275 = new class231(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(null == class152.field2275) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class152.field2275 = new class231(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "150"
   )
   static final void method1012() {
      if(class134.field2119 != null) {
         class134.field2119.method1222();
      }

      if(class0.field14 != null) {
         class0.field14.method1222();
      }

   }
}
