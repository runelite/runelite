import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class11 {
   @ObfuscatedName("r")
   static final class197 field164 = new class197(1024);
   @ObfuscatedName("f")
   static final class199 field165 = new class199();
   @ObfuscatedName("s")
   static int field166 = 0;
   @ObfuscatedName("a")
   static final Map field169 = new HashMap();
   @ObfuscatedName("jq")
   static class172[] field170;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-125460482"
   )
   static final void method156() {
      int var0 = 64 + class177.field2900 * 128;
      int var1 = class15.field217 * 128 + 64;
      int var2 = class4.method52(var0, var1, class48.field1078) - class161.field2633;
      if(class44.field1037 < var0) {
         class44.field1037 += class126.field2037 + class170.field2703 * (var0 - class44.field1037) / 1000;
         if(class44.field1037 > var0) {
            class44.field1037 = var0;
         }
      }

      if(class44.field1037 > var0) {
         class44.field1037 -= class126.field2037 + (class44.field1037 - var0) * class170.field2703 / 1000;
         if(class44.field1037 < var0) {
            class44.field1037 = var0;
         }
      }

      if(class30.field713 < var2) {
         class30.field713 += class170.field2703 * (var2 - class30.field713) / 1000 + class126.field2037;
         if(class30.field713 > var2) {
            class30.field713 = var2;
         }
      }

      if(class30.field713 > var2) {
         class30.field713 -= class170.field2703 * (class30.field713 - var2) / 1000 + class126.field2037;
         if(class30.field713 < var2) {
            class30.field713 = var2;
         }
      }

      if(class17.field254 < var1) {
         class17.field254 += class126.field2037 + (var1 - class17.field254) * class170.field2703 / 1000;
         if(class17.field254 > var1) {
            class17.field254 = var1;
         }
      }

      if(class17.field254 > var1) {
         class17.field254 -= class126.field2037 + (class17.field254 - var1) * class170.field2703 / 1000;
         if(class17.field254 < var1) {
            class17.field254 = var1;
         }
      }

      var0 = 64 + class18.field275 * 128;
      var1 = client.field543 * 128 + 64;
      var2 = class4.method52(var0, var1, class48.field1078) - class10.field160;
      int var3 = var0 - class44.field1037;
      int var4 = var2 - class30.field713;
      int var5 = var1 - class17.field254;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class15.field219 < var7) {
         class15.field219 += class148.field2215 * (var7 - class15.field219) / 1000 + class170.field2724;
         if(class15.field219 > var7) {
            class15.field219 = var7;
         }
      }

      if(class15.field219 > var7) {
         class15.field219 -= class148.field2215 * (class15.field219 - var7) / 1000 + class170.field2724;
         if(class15.field219 < var7) {
            class15.field219 = var7;
         }
      }

      int var9 = var8 - class13.field193;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class13.field193 += class148.field2215 * var9 / 1000 + class170.field2724;
         class13.field193 &= 2047;
      }

      if(var9 < 0) {
         class13.field193 -= class170.field2724 + -var9 * class148.field2215 / 1000;
         class13.field193 &= 2047;
      }

      int var10 = var8 - class13.field193;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class13.field193 = var8;
      }

   }

   @ObfuscatedName("bx")
   static final void method165(class30 var0, int var1, int var2) {
      class10.method145(var0.field703, var0.field704, var0.field705, var0.field706, var0.field707, var1, var2);
   }

   @ObfuscatedName("z")
   static class167 method166(int var0, boolean var1, boolean var2, boolean var3) {
      class133 var4 = null;
      if(class148.field2225 != null) {
         var4 = new class133(var0, class148.field2225, class228.field3221[var0], 1000000);
      }

      return new class167(var4, class15.field220, var0, var1, var2, var3);
   }

   @ObfuscatedName("y")
   static int method167(int var0) {
      class35 var1 = (class35)field164.method3849((long)var0);
      return null == var1?-1:(var1.field3099 == field165.field3095?-1:((class35)var1.field3099).field789);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   static final void method168() {
      for(class16 var0 = (class16)client.field427.method3860(); null != var0; var0 = (class16)client.field427.method3861()) {
         if(var0.field238 == -1) {
            var0.field237 = 0;
            class17.method205(var0);
         } else {
            var0.method3946();
         }
      }

   }

   @ObfuscatedName("y")
   static int method170(class25 var0, class25 var1, int var2, boolean var3) {
      if(1 == var2) {
         int var4 = var0.field635;
         int var5 = var1.field635;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(-1 == var5) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field644 - var1.field644:(var2 == 3?(var0.field643.equals("-")?(var1.field643.equals("-")?0:(var3?-1:1)):(var1.field643.equals("-")?(var3?1:-1):var0.field643.compareTo(var1.field643))):(var2 == 4?(var0.method609()?(var1.method609()?0:1):(var1.method609()?-1:0)):(var2 == 5?(var0.method615()?(var1.method615()?0:1):(var1.method615()?-1:0)):(var2 == 6?(var0.method601()?(var1.method601()?0:1):(var1.method601()?-1:0)):(7 == var2?(var0.method599()?(var1.method599()?0:1):(var1.method599()?-1:0)):var0.field638 - var1.field638)))));
      }
   }
}
