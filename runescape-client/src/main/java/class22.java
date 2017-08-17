import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class22 extends class28 {
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      longValue = -8467128941408346871L
   )
   static long field352;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static class290 field354;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 588013393
   )
   static int field350;
   @ObfuscatedName("rr")
   @ObfuscatedGetter(
      intValue = 900530585
   )
   static int field349;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;Lfb;I)V",
      garbageValue = "-439814413"
   )
   void method171(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field514.field509) {
         throw new IllegalStateException("");
      } else {
         super.field414 = var2.readUnsignedByte();
         super.field415 = var2.readUnsignedByte();
         super.field416 = var2.readUnsignedShort();
         super.field411 = var2.readUnsignedShort();
         super.field424 = var2.readUnsignedShort();
         super.field413 = var2.readUnsignedShort();
         super.field415 = Math.min(super.field415, 4);
         super.field419 = new short[1][64][64];
         super.field417 = new short[super.field415][64][64];
         super.field412 = new byte[super.field415][64][64];
         super.field423 = new byte[super.field415][64][64];
         super.field420 = new class31[super.field415][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field506.field503) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field424 && var5 == super.field413) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method237(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field424 | super.field413 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field424 == super.field424 && var2.field413 == super.field413;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1869481255"
   )
   static void method180(int var0, int var1, int var2, int var3) {
      Widget var4 = class205.method3812(var0, var1);
      if(var4 != null && var4.field2642 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.field856 = var4.field2642;
         Coordinates.method3942(var5);
      }

      Client.field1083 = var3;
      Client.spellSelected = true;
      class29.field434 = var0;
      Client.field1082 = var1;
      class51.field664 = var2;
      class90.method1723(var4);
   }

   @ObfuscatedName("h")
   public static String method181(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class269.field3661[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1089483364"
   )
   static void method179(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method179(var0, var1, var2, var5 - 1);
         method179(var0, var1, var5 + 1, var3);
      }

   }
}
