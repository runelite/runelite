import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("s")
   @Export("composition")
   class39 field782;
   @ObfuscatedName("kp")
   @Export("chatMessages")
   static class19 field784;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IBB)V",
      garbageValue = "1"
   )
   final void method696(int var1, byte var2) {
      int var3 = super.field866[0];
      int var4 = super.field863[0];
      if(0 == var1) {
         --var3;
         ++var4;
      }

      if(1 == var1) {
         ++var4;
      }

      if(2 == var1) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(5 == var1) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(-1 != super.field843 && class4.method42(super.field843).field1001 == 1) {
         super.field843 = -1;
      }

      if(super.field841 < 9) {
         ++super.field841;
      }

      for(int var5 = super.field841; var5 > 0; --var5) {
         super.field866[var5] = super.field866[var5 - 1];
         super.field863[var5] = super.field863[var5 - 1];
         super.field868[var5] = super.field868[var5 - 1];
      }

      super.field866[0] = var3;
      super.field863[0] = var4;
      super.field868[0] = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "1"
   )
   final void method697(int var1, int var2, boolean var3) {
      if(super.field843 != -1 && class4.method42(super.field843).field1001 == 1) {
         super.field843 = -1;
      }

      super.field841 = 0;
      super.field870 = 0;
      super.field869 = 0;
      super.field866[0] = var1;
      super.field863[0] = var2;
      super.field823 = super.field872 * 64 + super.field866[0] * 128;
      super.field813 = 128 * super.field863[0] + super.field872 * 64;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected final class105 vmethod1888() {
      if(this.field782 == null) {
         return null;
      } else {
         class42 var1 = super.field843 != -1 && 0 == super.field851?class4.method42(super.field843):null;
         class42 var2 = super.field840 != -1 && (super.field840 != super.field817 || null == var1)?class4.method42(super.field840):null;
         class105 var3 = this.field782.method742(var1, super.field844, var2, super.field861);
         if(var3 == null) {
            return null;
         } else {
            var3.method2287();
            super.field816 = var3.field1465;
            if(-1 != super.field848 && super.field849 != -1) {
               class105 var4 = class179.method3492(super.field848).method879(super.field849);
               if(var4 != null) {
                  var4.method2297(0, -super.field859, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field782.field887 == 1) {
               var3.field1834 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1677365606"
   )
   final boolean vmethod727() {
      return this.field782 != null;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)V",
      garbageValue = "-1659279042"
   )
   static void method701(class173 var0) {
      if(var0.field2897 == client.field487) {
         client.field482[var0.field2896] = true;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1200181043"
   )
   static int method709(int var0, int var1) {
      class15 var2 = (class15)class15.field204.method3777((long)var0);
      if(null == var2) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field206.length; ++var4) {
            if(var2.field210[var4] == var1) {
               var3 += var2.field206[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("j")
   public static String method710(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            char var4;
            StringBuilder var8;
            for(var8 = new StringBuilder(var2); var0 != 0L; var8.append(var4)) {
               long var5 = var0;
               var0 /= 37L;
               var4 = class162.field2652[(int)(var5 - var0 * 37L)];
               if(var4 == 95) {
                  int var7 = var8.length() - 1;
                  var8.setCharAt(var7, Character.toUpperCase(var8.charAt(var7)));
                  var4 = 160;
               }
            }

            var8.reverse();
            var8.setCharAt(0, Character.toUpperCase(var8.charAt(0)));
            return var8.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1621224061"
   )
   public static String method711(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(0 == var3) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class45.method931(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && 33 != var5) {
            if(Character.isSpaceChar(var5)) {
               if(2 != var3) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
