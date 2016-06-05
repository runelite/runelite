import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class157 {
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1044317938"
   )
   static final void method3139(String var0) {
      if(null != var0) {
         String var1 = class36.method723(var0, class96.field1641);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field418; ++var2) {
               class17 var3 = client.field551[var2];
               String var4 = var3.field239;
               String var5 = class36.method723(var4, class96.field1641);
               boolean var6;
               if(null != var0 && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field418;

                  for(int var7 = var2; var7 < client.field418; ++var7) {
                     client.field551[var7] = client.field551[var7 + 1];
                  }

                  client.field475 = client.field467;
                  client.field325.method2733(251);
                  client.field325.method2453(class102.method2237(var0));
                  client.field325.method2586(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILclass167;IIIZB)V",
      garbageValue = "2"
   )
   public static void method3140(int var0, class167 var1, int var2, int var3, int var4, boolean var5) {
      class183.field2981 = 1;
      class24.field614 = var1;
      class142.field2204 = var2;
      class183.field2977 = var3;
      class151.field2286 = var4;
      class29.field694 = var5;
      class183.field2980 = var0;
   }
}
