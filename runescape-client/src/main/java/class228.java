import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public enum class228 implements RSEnum {
   @ObfuscatedName("p")
   field3160(7, 0),
   @ObfuscatedName("m")
   field3156(4, 1),
   @ObfuscatedName("e")
   field3157(6, 2),
   @ObfuscatedName("t")
   field3155(2, 3),
   @ObfuscatedName("w")
   field3165(0, 4),
   @ObfuscatedName("z")
   field3159(1, 5),
   @ObfuscatedName("j")
   field3161(5, 6),
   @ObfuscatedName("i")
   field3162(3, 7);

   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 633818347
   )
   public final int field3163;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1099846007
   )
   final int field3164;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var3, int var4) {
      this.field3163 = var3;
      this.field3164 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3164;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-568108112"
   )
   public static byte[] method3971(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var5 = (byte[])((byte[])((byte[])var0));
         if(var1) {
            int var3 = var5.length;
            byte[] var4 = new byte[var3];
            System.arraycopy(var5, 0, var4, 0, var3);
            return var4;
         } else {
            return var5;
         }
      } else if(var0 instanceof class176) {
         class176 var2 = (class176)var0;
         return var2.vmethod3256();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
