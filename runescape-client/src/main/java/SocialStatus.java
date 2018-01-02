import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("SocialStatus")
public class SocialStatus {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final SocialStatus field3806;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   public static final SocialStatus field3807;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final SocialStatus field3808;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 488305935
   )
   public final int field3809;

   static {
      field3806 = new SocialStatus(0);
      field3807 = new SocialStatus(1);
      field3808 = new SocialStatus(2);
   }

   SocialStatus(int var1) {
      this.field3809 = var1;
   }
}
