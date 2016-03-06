import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class213 {
   @ObfuscatedName("a")
   public final class219 field3142;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 6976904459576955929L
   )
   public final long field3143;
   @ObfuscatedName("i")
   String field3144;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -1800740669
   )
   static int field3145;
   @ObfuscatedName("f")
   String field3146;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 775167693
   )
   public final int field3147;

   @ObfuscatedName("j")
   public String method3882() {
      return this.field3144;
   }

   @ObfuscatedName("l")
   public String method3883() {
      return this.field3146;
   }

   class213(class118 var1, byte var2, int var3) {
      this.field3144 = var1.method2461();
      this.field3146 = var1.method2461();
      this.field3147 = var1.method2455();
      this.field3143 = var1.method2632();
      int var4 = var1.method2458();
      int var5 = var1.method2458();
      this.field3142 = new class219();
      this.field3142.method3931(2);
      this.field3142.method3932(var2);
      this.field3142.field3169 = var4;
      this.field3142.field3167 = var5;
      this.field3142.field3168 = 0;
      this.field3142.field3164 = 0;
      this.field3142.field3165 = var3;
   }
}
