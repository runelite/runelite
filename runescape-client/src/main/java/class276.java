import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public class class276 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   static final class276 field3720;
   @ObfuscatedName("ag")
   static FontMetrics field3723;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   public static final class276 field3718;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   static final class276 field3719;
   @ObfuscatedName("nr")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   static class276 field3721;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 425670159
   )
   public final int field3722;

   static {
      field3720 = new class276(0);
      field3718 = new class276(1);
      field3719 = new class276(2);
   }

   class276(int var1) {
      this.field3722 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lim;II)Z",
      garbageValue = "732280810"
   )
   public static boolean method4911(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4119(var1);
      if(var2 == null) {
         return false;
      } else {
         Timer.decodeSprite(var2);
         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;Ljava/lang/String;Ljava/lang/String;B)Ljt;",
      garbageValue = "-9"
   )
   public static Font method4910(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return class87.method1713(var0, var1, var4, var5);
   }
}
