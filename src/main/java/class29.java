import java.awt.Font;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public final class class29 extends class85 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 741424053
   )
   int field697;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 683165551
   )
   int field698;
   @ObfuscatedName("s")
   static int[] field699;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2031543663
   )
   int field700;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1857934231
   )
   int field701;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 969679089
   )
   int field702 = 0;
   @ObfuscatedName("y")
   class42 field703;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 119451075
   )
   int field704;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2032636251
   )
   int field705;
   @ObfuscatedName("m")
   boolean field706 = false;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1620193643
   )
   int field707 = 0;
   @ObfuscatedName("qm")
   static Font field708;
   @ObfuscatedName("aw")
   static class168 field709;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-66"
   )
   final void method736(int var1) {
      if(!this.field706) {
         this.field702 += var1;

         while(this.field702 > this.field703.field995[this.field707]) {
            this.field702 -= this.field703.field995[this.field707];
            ++this.field707;
            if(this.field707 >= this.field703.field989.length) {
               this.field706 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected final class105 vmethod1999() {
      class43 var1 = class25.method693(this.field705);
      class105 var2;
      if(!this.field706) {
         var2 = var1.method994(this.field707);
      } else {
         var2 = var1.method994(-1);
      }

      return var2 == null?null:var2;
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field705 = var1;
      this.field697 = var2;
      this.field704 = var3;
      this.field701 = var4;
      this.field700 = var5;
      this.field698 = var6 + var7;
      int var8 = class25.method693(this.field705).field1021;
      if(var8 != -1) {
         this.field706 = false;
         this.field703 = class96.method2279(var8);
      } else {
         this.field706 = true;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   static final void method740() {
      for(class29 var0 = (class29)client.field428.method3926(); null != var0; var0 = (class29)client.field428.method3902()) {
         if(class42.field1002 == var0.field697 && !var0.field706) {
            if(client.field306 >= var0.field698) {
               var0.method736(client.field427);
               if(var0.field706) {
                  var0.method3998();
               } else {
                  class30.field717.method2019(var0.field697, var0.field704, var0.field701, var0.field700, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3998();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "255"
   )
   public static void method742(class167 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3377(var1);
      int var6 = var0.method3378(var5, var2);
      class144.method3157(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1740540884"
   )
   static final void method744(int var0, int var1) {
      if(client.field434 >= 2 || 0 != client.field448 || client.field447) {
         String var2;
         if(client.field448 == 1 && client.field434 < 2) {
            var2 = "Use" + " " + client.field378 + " " + "->";
         } else if(client.field447 && client.field434 < 2) {
            var2 = client.field297 + " " + client.field534 + " " + "->";
         } else {
            int var4 = client.field434 - 1;
            String var3;
            if(client.field440[var4].length() > 0) {
               var3 = client.field439[var4] + " " + client.field440[var4];
            } else {
               var3 = client.field439[var4];
            }

            var2 = var3;
         }

         if(client.field434 > 2) {
            var2 = var2 + class139.method3046(16777215) + " " + '/' + " " + (client.field434 - 2) + " more options";
         }

         class33.field781.method4150(var2, var0 + 4, 15 + var1, 16777215, 0, client.field306 / 1000);
      }
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1"
   )
   static void method745(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class51.field1118; ++var4) {
         class51 var5 = class11.method178(var4);
         if(var5.field1166 && var5.field1156 == -1 && var5.field1125.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class13.field210 = -1;
               class30.field716 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class30.field716 = var2;
      class43.field1034 = 0;
      class13.field210 = var3;
      String[] var8 = new String[class13.field210];

      for(int var9 = 0; var9 < class13.field210; ++var9) {
         var8[var9] = class11.method178(var2[var9]).field1125;
      }

      class96.method2277(var8, class30.field716);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "77"
   )
   public static int method746(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class51.method1136(var0.charAt(var3));
      }

      return var2;
   }
}
