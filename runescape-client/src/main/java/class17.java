import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class17 implements Comparator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lk;Lk;I)I",
      garbageValue = "-639971200"
   )
   int method132(class14 var1, class14 var2) {
      return var1.field285.price < var2.field285.price?-1:(var2.field285.price == var1.field285.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method132((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZZI)Lko;",
      garbageValue = "-833786430"
   )
   static IndexedSprite method144(boolean var0, boolean var1) {
      return var0?(var1?class82.field1265:class296.field3859):(var1?Preferences.field1235:WallObject.field2046);
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-464622192"
   )
   static final void method143(String var0) {
      if(var0 != null) {
         String var1 = PacketBuffer.method3598(var0, class60.field718);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = PacketBuffer.method3598(var4, class60.field718);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[var7 + 1];
                  }

                  Client.field1042 = Client.cycleCntr;
                  class170 var8 = Actor.method1628(class167.field2391, Client.field952.field1478);
                  var8.field2423.putByte(Projectile.getLength(var0));
                  var8.field2423.putString(var0);
                  Client.field952.method1951(var8);
                  break;
               }
            }

         }
      }
   }
}
