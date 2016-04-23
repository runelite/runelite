import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class44 extends class204 {
   @ObfuscatedName("c")
   short[] field1009;
   @ObfuscatedName("j")
   public static class167 field1010;
   @ObfuscatedName("i")
   short[] field1011;
   @ObfuscatedName("z")
   static class193 field1012 = new class193(64);
   @ObfuscatedName("e")
   int[] field1013;
   @ObfuscatedName("h")
   public static class167 field1014;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -826489285
   )
   public int field1015 = -1;
   @ObfuscatedName("n")
   short[] field1016;
   @ObfuscatedName("l")
   short[] field1017;
   @ObfuscatedName("u")
   int[] field1018 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("r")
   public boolean field1019 = false;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "370108113"
   )
   void method903(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method904(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1875397460"
   )
   void method904(class119 var1, int var2) {
      if(1 == var2) {
         this.field1015 = var1.method2500();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2500();
            this.field1013 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1013[var4] = var1.method2502();
            }
         } else if(var2 == 3) {
            this.field1019 = true;
         } else if(var2 == 40) {
            var3 = var1.method2500();
            this.field1011 = new short[var3];
            this.field1009 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1011[var4] = (short)var1.method2502();
               this.field1009[var4] = (short)var1.method2502();
            }
         } else if(41 == var2) {
            var3 = var1.method2500();
            this.field1016 = new short[var3];
            this.field1017 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1016[var4] = (short)var1.method2502();
               this.field1017[var4] = (short)var1.method2502();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1018[var2 - 60] = var1.method2502();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-23795307"
   )
   public boolean method905() {
      if(this.field1013 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1013.length; ++var2) {
            if(!field1014.method3294(this.field1013[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "1054070499"
   )
   public class100 method906() {
      if(null == this.field1013) {
         return null;
      } else {
         class100[] var1 = new class100[this.field1013.length];

         for(int var2 = 0; var2 < this.field1013.length; ++var2) {
            var1[var2] = class100.method2198(field1014, this.field1013[var2], 0);
         }

         class100 var4;
         if(1 == var1.length) {
            var4 = var1[0];
         } else {
            var4 = new class100(var1, var1.length);
         }

         int var3;
         if(this.field1011 != null) {
            for(var3 = 0; var3 < this.field1011.length; ++var3) {
               var4.method2202(this.field1011[var3], this.field1009[var3]);
            }
         }

         if(null != this.field1016) {
            for(var3 = 0; var3 < this.field1016.length; ++var3) {
               var4.method2214(this.field1016[var3], this.field1017[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "312294512"
   )
   public boolean method907() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(-1 != this.field1018[var2] && !field1014.method3294(this.field1018[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1724864860"
   )
   public static String method910(CharSequence var0) {
      return class137.method2898('*', var0.length());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass100;",
      garbageValue = "-1823925625"
   )
   public class100 method912() {
      class100[] var1 = new class100[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1018[var3] != -1) {
            var1[var2++] = class100.method2198(field1014, this.field1018[var3], 0);
         }
      }

      class100 var5 = new class100(var1, var2);
      int var4;
      if(null != this.field1011) {
         for(var4 = 0; var4 < this.field1011.length; ++var4) {
            var5.method2202(this.field1011[var4], this.field1009[var4]);
         }
      }

      if(null != this.field1016) {
         for(var4 = 0; var4 < this.field1016.length; ++var4) {
            var5.method2214(this.field1016[var4], this.field1017[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1779853960"
   )
   static void method933() {
      client var0 = client.field272;
      synchronized(client.field272) {
         Container var1 = client.field272.method2999();
         if(null != var1) {
            class129.field2028 = Math.max(var1.getSize().width, class41.field965);
            class37.field809 = Math.max(var1.getSize().height, class31.field724);
            if(class4.field82 == var1) {
               Insets var2 = class4.field82.getInsets();
               class129.field2028 -= var2.left + var2.right;
               class37.field809 -= var2.top + var2.bottom;
            }

            if(class129.field2028 <= 0) {
               class129.field2028 = 1;
            }

            if(class37.field809 <= 0) {
               class37.field809 = 1;
            }

            int var12 = client.field487?2:1;
            if(var12 == 1) {
               class5.field102 = client.field488;
               class39.field901 = client.field489;
            } else {
               class5.field102 = Math.min(class129.field2028, 7680);
               class39.field901 = Math.min(class37.field809, 2160);
            }

            class144.field2172 = (class129.field2028 - class5.field102) / 2;
            class144.field2182 = 0;
            class3.field66.setSize(class5.field102, class39.field901);
            int var4 = class5.field102;
            int var5 = class39.field901;
            Canvas var6 = class3.field66;

            Object var3;
            try {
               class81 var7 = new class81();
               var7.vmethod1872(var4, var5, var6);
               var3 = var7;
            } catch (Throwable var10) {
               class75 var8 = new class75();
               var8.vmethod1872(var4, var5, var6);
               var3 = var8;
            }

            class75.field1363 = (class77)var3;
            if(var1 == class4.field82) {
               Insets var13 = class4.field82.getInsets();
               class3.field66.setLocation(class144.field2172 + var13.left, var13.top + class144.field2182);
            } else {
               class3.field66.setLocation(class144.field2172, class144.field2182);
            }

            class72.method1571();
            if(-1 != client.field433) {
               class72.method1569(true);
            }

            class21.method565();
         }
      }
   }
}
