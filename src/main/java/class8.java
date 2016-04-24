import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class8 {
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -428604903
   )
   static int field140;
   @ObfuscatedName("e")
   LinkedHashMap field142 = new LinkedHashMap();
   @ObfuscatedName("z")
   boolean field143;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1867809613
   )
   int field144 = 1;
   @ObfuscatedName("m")
   boolean field145;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1603552573
   )
   static int field146 = 4;

   class8() {
      this.method121(true);
   }

   class8(class119 var1) {
      if(null != var1 && var1.field1973 != null) {
         int var2 = var1.method2500();
         if(var2 >= 0 && var2 <= field146) {
            if(var1.method2500() == 1) {
               this.field145 = true;
            }

            if(var2 > 1) {
               this.field143 = var1.method2500() == 1;
            }

            if(var2 > 3) {
               this.field144 = var1.method2500();
            }

            if(var2 > 2) {
               int var3 = var1.method2500();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2505();
                  int var6 = var1.method2505();
                  this.field142.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method121(true);
         }
      } else {
         this.method121(true);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-424325275"
   )
   @Export("sendGameMessage")
   static void method109(int var0, String var1, String var2) {
      class77.method1685(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lclass119;",
      garbageValue = "-1122215295"
   )
   class119 method110() {
      class119 var1 = new class119(100);
      var1.method2503(field146);
      var1.method2503(this.field145?1:0);
      var1.method2503(this.field143?1:0);
      var1.method2503(this.field144);
      var1.method2503(this.field142.size());
      Iterator var2 = this.field142.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2488(((Integer)var3.getKey()).intValue());
         var1.method2488(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass80;I)V",
      garbageValue = "-1747590477"
   )
   static final void method111(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class56.field1165.length; ++var2) {
         class56.field1165[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class56.field1165[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class9.field152[var5] = (class56.field1165[var5 - 1] + class56.field1165[1 + var5] + class56.field1165[var5 - 128] + class56.field1165[var5 + 128]) / 4;
            }
         }

         int[] var8 = class56.field1165;
         class56.field1165 = class9.field152;
         class9.field152 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1401; ++var3) {
            for(var4 = 0; var4 < var0.field1403; ++var4) {
               if(var0.field1402[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1406;
                  int var6 = var0.field1404 + var3 + 16;
                  int var7 = (var6 << 7) + var5;
                  class56.field1165[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIB)V",
      garbageValue = "32"
   )
   static final void method119(class173 var0, int var1, int var2) {
      if(0 == client.field509 || client.field509 == 3) {
         if(1 == class140.field2134 || !class139.field2116 && class140.field2134 == 4) {
            class175 var3 = var0.method3369(true);
            if(var3 == null) {
               return;
            }

            int var4 = class140.field2135 - var1;
            int var5 = class140.field2136 - var2;
            if(var3.method3411(var4, var5)) {
               var4 -= var3.field2890 / 2;
               var5 -= var3.field2891 / 2;
               int var6 = client.field346 + client.field521 & 2047;
               int var7 = class91.field1571[var6];
               int var8 = class91.field1572[var6];
               var7 = (client.field479 + 256) * var7 >> 8;
               var8 = (client.field479 + 256) * var8 >> 8;
               int var9 = var8 * var4 + var5 * var7 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = var9 + class47.field1053.field816 >> 7;
               int var12 = class47.field1053.field840 - var10 >> 7;
               client.field318.method2735(88);
               client.field318.method2503(18);
               client.field318.method2486(class187.field3014 + var11);
               client.field318.method2597(class137.field2095[82]?(class137.field2095[81]?2:1):0);
               client.field318.method2533(class0.field12 + var12);
               client.field318.method2503(var4);
               client.field318.method2503(var5);
               client.field318.method2486(client.field521);
               client.field318.method2503(57);
               client.field318.method2503(client.field346);
               client.field318.method2503(client.field479);
               client.field318.method2503(89);
               client.field318.method2486(class47.field1053.field816);
               client.field318.method2486(class47.field1053.field840);
               client.field318.method2503(63);
               client.field507 = var11;
               client.field508 = var12;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2145219768"
   )
   public static void method120() {
      class43.field989.method3707();
      class43.field990.method3707();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   void method121(boolean var1) {
   }
}
