import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class151 extends class158 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -194421875
   )
   int field2223;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -657777465
   )
   int field2224;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1818445197
   )
   int field2225;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 6946735072449436995L
   )
   long field2226;
   @ObfuscatedName("i")
   long[] field2227;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1739731017
   )
   int field2228;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2037706163
   )
   public static int field2229;

   public class151() {
      this.field2227 = new long[10];
      this.field2224 = 256;
      this.field2225 = 1;
      this.field2223 = 0;
      this.field2226 = XGrandExchangeOffer.method96();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2227[var1] = this.field2226;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-472854462"
   )
   public int vmethod2972(int var1, int var2) {
      int var3 = this.field2224;
      int var4 = this.field2225;
      this.field2224 = 300;
      this.field2225 = 1;
      this.field2226 = XGrandExchangeOffer.method96();
      if(this.field2227[this.field2228] == 0L) {
         this.field2224 = var3;
         this.field2225 = var4;
      } else if(this.field2226 > this.field2227[this.field2228]) {
         this.field2224 = (int)((long)(var1 * 2560) / (this.field2226 - this.field2227[this.field2228]));
      }

      if(this.field2224 < 25) {
         this.field2224 = 25;
      }

      if(this.field2224 > 256) {
         this.field2224 = 256;
         this.field2225 = (int)((long)var1 - (this.field2226 - this.field2227[this.field2228]) / 10L);
      }

      if(this.field2225 > var1) {
         this.field2225 = var1;
      }

      this.field2227[this.field2228] = this.field2226;
      this.field2228 = (this.field2228 + 1) % 10;
      int var5;
      if(this.field2225 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field2227[var5]) {
               this.field2227[var5] += (long)this.field2225;
            }
         }
      }

      if(this.field2225 < var2) {
         this.field2225 = var2;
      }

      class4.method9((long)this.field2225);

      for(var5 = 0; this.field2223 < 256; this.field2223 += this.field2224) {
         ++var5;
      }

      this.field2223 &= 255;
      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   public void vmethod2971() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2227[var1] = 0L;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "635772653"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class155.field2264, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class155.field2271 == 33) {
         var4 = "_rc";
      } else if(class155.field2271 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class76.field1218, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-524871345"
   )
   public static int method2920(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class19.method131(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1976596097"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method1858(var0, var1, var2, var3);
      class98.field1532.method3476(var5, (long)var5.id);
      class98.field1534.method3642(var5);
      Client.field1037 = Client.field1121;
   }
}
