import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("k")
   short[] field2818;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1091440961
   )
   public static int field2819;
   @ObfuscatedName("g")
   public static NodeCache field2820 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -27634609
   )
   public int field2821 = -1;
   @ObfuscatedName("u")
   short[] field2822;
   @ObfuscatedName("l")
   short[] field2823;
   @ObfuscatedName("c")
   short[] field2824;
   @ObfuscatedName("v")
   int[] field2825;
   @ObfuscatedName("y")
   public boolean field2826 = false;
   @ObfuscatedName("z")
   int[] field2827 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("o")
   public static class182 field2828;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "2132529973"
   )
   static char method3400(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1848021374"
   )
   void method3401(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3402(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1895806940"
   )
   void method3402(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2821 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2825 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2825[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2826 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2823 = new short[var3];
            this.field2824 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2823[var4] = (short)var1.readUnsignedShort();
               this.field2824[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2822 = new short[var3];
            this.field2818 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2822[var4] = (short)var1.readUnsignedShort();
               this.field2818[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2827[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1835534689"
   )
   @Export("ready")
   public boolean ready() {
      if(this.field2825 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2825.length; ++var2) {
            if(!class8.field60.method3205(this.field2825[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1532408917"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2825 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2825.length];

         for(int var2 = 0; var2 < this.field2825.length; ++var2) {
            var1[var2] = ModelData.method1434(class8.field60, this.field2825[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2823) {
            for(var3 = 0; var3 < this.field2823.length; ++var3) {
               var4.method1448(this.field2823[var3], this.field2824[var3]);
            }
         }

         if(this.field2822 != null) {
            for(var3 = 0; var3 < this.field2822.length; ++var3) {
               var4.method1449(this.field2822[var3], this.field2818[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1743134114"
   )
   public boolean method3405() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2827[var2] != -1 && !class8.field60.method3205(this.field2827[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "777224387"
   )
   public ModelData method3406() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2827[var3] != -1) {
            var1[var2++] = ModelData.method1434(class8.field60, this.field2827[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field2823 != null) {
         for(var4 = 0; var4 < this.field2823.length; ++var4) {
            var5.method1448(this.field2823[var4], this.field2824[var4]);
         }
      }

      if(null != this.field2822) {
         for(var4 = 0; var4 < this.field2822.length; ++var4) {
            var5.method1449(this.field2822[var4], this.field2818[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "-122"
   )
   public static String method3411(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = 43;

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - 10 * var3;
               if(var9 >= 10) {
                  var6[var7] = (char)(var9 + 87);
               } else {
                  var6[var7] = (char)(var9 + 48);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "1"
   )
   static char method3426(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1109124525"
   )
   public static int method3427(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2049321506"
   )
   static void method3429() {
      int var0 = GameEngine.field1788;
      int var1 = GameEngine.field1793;
      int var2 = class105.field1720 - TextureProvider.field1200 - var0;
      int var3 = class45.field914 - class94.field1584 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field540.method2069();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class112.field1777) {
               Insets var7 = class112.field1777.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class45.field914);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class105.field1720, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class105.field1720 + var5 - var2, var6, var2, class45.field914);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class45.field914 - var3, class105.field1720, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
