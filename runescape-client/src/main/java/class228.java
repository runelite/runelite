import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class228 implements RSEnum {
   @ObfuscatedName("t")
   public static final class228 field3155;
   @ObfuscatedName("m")
   public static final class228 field3156;
   @ObfuscatedName("e")
   public static final class228 field3157;
   @ObfuscatedName("z")
   public static final class228 field3159;
   @ObfuscatedName("p")
   public static final class228 field3160;
   @ObfuscatedName("j")
   public static final class228 field3161;
   @ObfuscatedName("i")
   public static final class228 field3162;
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
   @ObfuscatedName("w")
   public static final class228 field3165;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var1, int var2) {
      this.field3163 = var1;
      this.field3164 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int ordinal() {
      return this.field3164;
   }

   static {
      field3160 = new class228(7, 0);
      field3156 = new class228(4, 1);
      field3157 = new class228(6, 2);
      field3155 = new class228(2, 3);
      field3165 = new class228(0, 4);
      field3159 = new class228(1, 5);
      field3161 = new class228(5, 6);
      field3162 = new class228(3, 7);
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
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class176) {
         class176 var2 = (class176)var0;
         return var2.vmethod3256();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
