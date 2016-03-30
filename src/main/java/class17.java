import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("nk")
   static class56 field253;
   @ObfuscatedName("x")
   @Export("previousName")
   String field254;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 371538715
   )
   @Export("world")
   int field255;
   @ObfuscatedName("e")
   boolean field257;
   @ObfuscatedName("y")
   boolean field258;
   @ObfuscatedName("w")
   @Export("name")
   String field260;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1839406029
   )
   int field261;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass33;B)V",
      garbageValue = "47"
   )
   static final void method185(class33 var0) {
      if(client.field533 == class167.field2692.field849 >> 7 && client.field529 == class167.field2692.field819 >> 7) {
         client.field533 = 0;
      }

      int var1 = class32.field751;
      int[] var2 = class32.field757;
      int var3 = var1;
      if(class33.field774 == var0 || class33.field767 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(var0 == class33.field774) {
            var5 = class167.field2692;
            var6 = class167.field2692.field60 << 14;
         } else if(class33.field767 == var0) {
            var5 = client.field415[client.field424];
            var6 = client.field424 << 14;
         } else {
            var5 = client.field415[var2[var4]];
            var6 = var2[var4] << 14;
            if(class33.field769 == var0 && client.field424 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod781() && !var5.field43) {
            var5.field56 = false;
            if((client.field413 && var1 > 50 || var1 > 200) && var0 != class33.field774 && var5.field823 == var5.field846) {
               var5.field56 = true;
            }

            int var7 = var5.field849 >> 7;
            int var8 = var5.field819 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field51 != null && client.field305 >= var5.field46 && client.field305 < var5.field57) {
                  var5.field56 = false;
                  var5.field45 = class43.method938(var5.field849, var5.field819, class82.field1437);
                  class3.field75.method1920(class82.field1437, var5.field849, var5.field819, var5.field45, var5, var5.field820, var6, var5.field52, var5.field53, var5.field54, var5.field67);
               } else {
                  if((var5.field849 & 127) == 64 && (var5.field819 & 127) == 64) {
                     if(client.field329 == client.field398[var7][var8]) {
                        continue;
                     }

                     client.field398[var7][var8] = client.field329;
                  }

                  var5.field45 = class43.method938(var5.field849, var5.field819, class82.field1437);
                  class3.field75.method1919(class82.field1437, var5.field849, var5.field819, var5.field45, 60, var5, var5.field820, var6, var5.field870);
               }
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIB)V",
      garbageValue = "0"
   )
   static void method186(class2 var0, int var1, int var2) {
      if(var0.field821 == var1 && -1 != var1) {
         int var3 = class96.method2187(var1).field1008;
         if(var3 == 1) {
            var0.field850 = 0;
            var0.field861 = 0;
            var0.field852 = var2;
            var0.field853 = 0;
         }

         if(var3 == 2) {
            var0.field853 = 0;
         }
      } else if(-1 == var1 || var0.field821 == -1 || class96.method2187(var1).field1002 >= class96.method2187(var0.field821).field1002) {
         var0.field821 = var1;
         var0.field850 = 0;
         var0.field861 = 0;
         var0.field852 = var2;
         var0.field853 = 0;
         var0.field875 = var0.field818;
      }

   }

   @ObfuscatedName("cq")
   static void method187(int var0, int var1) {
      class30 var2 = class76.field1386;
      class163.method3263(var2.field713, var2.field706, var2.field710, var2.field708, var2.field709, var0, var1);
      class76.field1386 = null;
   }

   @ObfuscatedName("z")
   static class103 method188(int var0) {
      class103 var1 = (class103)class42.field994.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class167 var3 = class42.field992;
         class167 var4 = class125.field2048;
         boolean var5 = true;
         int[] var6 = var3.method3332(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3294(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3294(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         class103 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class103(var3, var4, var0, false);
            } catch (Exception var11) {
               var2 = null;
            }
         }

         if(var2 != null) {
            class42.field994.method3773(var2, (long)var0);
         }

         return var2;
      }
   }
}
