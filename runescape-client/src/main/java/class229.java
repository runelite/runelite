import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public enum class229 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3150(3, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3143(2, 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3144(0, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3145(6, 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3146(1, 4),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3147(7, 5),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3153(5, 6),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   field3148(4, 7);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1502443041
   )
   final int field3142;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1753155741
   )
   public final int field3149;

   class229(int var3, int var4) {
      this.field3149 = var3;
      this.field3142 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field3142;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-707239856"
   )
   static void method4092() {
      Object var0 = class237.field3222;
      synchronized(class237.field3222) {
         if(class237.field3219 == 0) {
            class237.field3221 = new Thread(new class237());
            class237.field3221.setDaemon(true);
            class237.field3221.start();
            class237.field3221.setPriority(5);
         }

         class237.field3219 = 600;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)Ljava/lang/String;",
      garbageValue = "-1997738653"
   )
   public static String method4091(Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class266.field3648.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = ScriptEvent.getString(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }
}
