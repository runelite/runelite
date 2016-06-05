import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public abstract class class107 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 408561667
   )
   public int field1883;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1064259073
   )
   public int field1884;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1552199947
   )
   static int field1886;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1173011259
   )
   public int field1887;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1947477523
   )
   public int field1889;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "335519834"
   )
   protected abstract boolean vmethod2345(int var1, int var2, int var3, class108 var4);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2033407432"
   )
   public static void method2346() {
      while(true) {
         class199 var1 = class170.field2738;
         class169 var0;
         synchronized(class170.field2738) {
            var0 = (class169)class170.field2737.method3789();
         }

         if(null == var0) {
            return;
         }

         var0.field2734.method3310(var0.field2732, (int)var0.field3125, var0.field2731, false);
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1433814697"
   )
   static void method2349(int var0, String var1) {
      int var2 = class32.field741;
      int[] var3 = class32.field742;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         class2 var6 = client.field405[var3[var5]];
         if(var6 != null && var6 != class152.field2301 && var6.field39 != null && var6.field39.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               client.field325.method2733(79);
               client.field325.method2500(var3[var5]);
               client.field325.method2594(0);
            } else if(var0 == 4) {
               client.field325.method2733(87);
               client.field325.method2501(var3[var5]);
               client.field325.method2594(0);
            } else if(var0 == 6) {
               client.field325.method2733(89);
               client.field325.method2488(0);
               client.field325.method2500(var3[var5]);
            } else if(var0 == 7) {
               client.field325.method2733(38);
               client.field325.method2502(var3[var5]);
               client.field325.method2492(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class33.method702(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   public static void method2350() {
      if(null != class140.field2186) {
         class140 var0 = class140.field2186;
         synchronized(class140.field2186) {
            class140.field2186 = null;
         }
      }

   }
}
