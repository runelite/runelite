import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class54 extends class207 {
   @ObfuscatedName("ej")
   static class81[] field1165;
   @ObfuscatedName("w")
   public static class196 field1166 = new class196(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 738675249
   )
   public int field1167 = 0;
   @ObfuscatedName("m")
   public static class170 field1170;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-87"
   )
   void method1125(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1167 = var1.method2706();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "494691559"
   )
   public void method1129(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1125(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "8"
   )
   public static void method1130(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            var2 = class6.method94(var1);
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
         if(null == class151.field2285) {
            return;
         }

         URL var3 = new URL(class151.field2285.getCodeBase(), "clienterror.ws?c=" + class151.field2286 + "&u=" + class46.field1060 + "&v1=" + class139.field2147 + "&v2=" + class139.field2143 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILclass137;Lclass171;I)V",
      garbageValue = "-1929683128"
   )
   static void method1131(int var0, class137 var1, class171 var2) {
      class172 var3 = new class172();
      var3.field2753 = 1;
      var3.field3167 = (long)var0;
      var3.field2754 = var1;
      var3.field2752 = var2;
      class202 var4 = class173.field2759;
      synchronized(class173.field2759) {
         class173.field2759.method3877(var3);
      }

      Object var9 = class173.field2756;
      synchronized(class173.field2756) {
         if(class173.field2758 == 0) {
            class40.field900.method2937(new class173(), 5);
         }

         class173.field2758 = 600;
      }
   }
}
