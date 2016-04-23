import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public abstract class class107 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1566883447
   )
   public int field1858;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -391418253
   )
   public int field1859;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1089833161
   )
   public int field1861;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -525672009
   )
   public int field1863;
   @ObfuscatedName("ri")
   protected static boolean field1864;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1911528168"
   )
   public static boolean method2374(int var0) {
      if(class173.field2792[var0]) {
         return true;
      } else if(!class173.field2736.method3220(var0)) {
         return false;
      } else {
         int var1 = class173.field2736.method3227(var0);
         if(0 == var1) {
            class173.field2792[var0] = true;
            return true;
         } else {
            if(null == class173.field2735[var0]) {
               class173.field2735[var0] = new class173[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class173.field2735[var0][var2] == null) {
                  byte[] var3 = class173.field2736.method3217(var0, var2);
                  if(var3 != null) {
                     class173.field2735[var0][var2] = new class173();
                     class173.field2735[var0][var2].field2774 = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class173.field2735[var0][var2].method3390(new class119(var3));
                     } else {
                        class173.field2735[var0][var2].method3376(new class119(var3));
                     }
                  }
               }
            }

            class173.field2792[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "85503227"
   )
   protected abstract boolean vmethod2375(int var1, int var2, int var3, class108 var4);
}
