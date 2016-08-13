import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class13 implements Runnable {
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 1635200715
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("g")
   Object field203 = new Object();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -881540557
   )
   int field204 = 0;
   @ObfuscatedName("h")
   int[] field205 = new int[500];
   @ObfuscatedName("l")
   boolean field206 = true;
   @ObfuscatedName("n")
   static int[][] field207;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 1622214761
   )
   static int field209;
   @ObfuscatedName("e")
   int[] field210 = new int[500];

   public void run() {
      for(; this.field206; class22.method594(50L)) {
         Object var1 = this.field203;
         Object var2 = this.field203;
         synchronized(this.field203) {
            if(this.field204 < 500) {
               this.field210[this.field204] = class143.field2206;
               this.field205[this.field204] = class143.field2209;
               ++this.field204;
            }
         }
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1328107807"
   )
   static final void method175(Widget var0, int var1, int var2) {
      if(Client.field466 == null && !Client.isMenuOpen && null != var0 && GameObject.method2287(var0) != null) {
         Client.field466 = var0;
         Client.field397 = GameObject.method2287(var0);
         Client.field387 = var1;
         Client.field472 = var2;
         class188.field3055 = 0;
         Client.field390 = false;
         if(Client.menuOptionCount > 0) {
            int var3 = Client.menuOptionCount - 1;
            class75.field1423 = new class32();
            class75.field1423.field729 = Client.menuActionParams0[var3];
            class75.field1423.field739 = Client.menuActionParams1[var3];
            class75.field1423.field737 = Client.menuTypes[var3];
            class75.field1423.field732 = Client.menuIdentifiers[var3];
            class75.field1423.field733 = Client.menuOptions[var3];
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "-53"
   )
   public static void method176(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            var2 = SecondaryBufferProvider.method1713(var1);
         }

         if(null != var0) {
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class151.field2286) {
            return;
         }

         URL var3 = new URL(class151.field2286.getCodeBase(), "clienterror.ws?c=" + class151.field2284 + "&u=" + class151.field2287 + "&v1=" + class139.field2152 + "&v2=" + class139.field2146 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }
}
