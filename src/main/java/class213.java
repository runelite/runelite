import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public class class213 {
   @ObfuscatedName("f")
   public final class219 field3139;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 3336522195039149473L
   )
   public final long field3140;
   @ObfuscatedName("s")
   String field3141;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -487228125
   )
   public final int field3142;
   @ObfuscatedName("y")
   String field3143;
   @ObfuscatedName("bu")
   static class167 field3146;

   @ObfuscatedName("a")
   public String method3985() {
      return this.field3141;
   }

   @ObfuscatedName("r")
   public String method3986() {
      return this.field3143;
   }

   class213(class118 var1, byte var2, int var3) {
      this.field3141 = var1.method2520();
      this.field3143 = var1.method2520();
      this.field3142 = var1.method2514();
      this.field3140 = var1.method2518();
      int var4 = var1.method2517();
      int var5 = var1.method2517();
      this.field3139 = new class219();
      this.field3139.method4030(2);
      this.field3139.method4031(var2);
      this.field3139.field3164 = var4;
      this.field3139.field3162 = var5;
      this.field3139.field3165 = 0;
      this.field3139.field3167 = 0;
      this.field3139.field3163 = var3;
   }
}
