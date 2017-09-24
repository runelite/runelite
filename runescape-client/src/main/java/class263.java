import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class263 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   IndexDataBase field3632;
   @ObfuscatedName("a")
   HashMap field3630;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   IndexDataBase field3631;

   @ObfuscatedSignature(
      signature = "(Lii;Lii;)V"
   )
   public class263(IndexDataBase var1, IndexDataBase var2) {
      this.field3632 = var1;
      this.field3631 = var2;
      this.field3630 = new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljz;I)Ljava/util/HashMap;",
      garbageValue = "-911827196"
   )
   public HashMap method4701(class262[] var1) {
      HashMap var2 = new HashMap();
      class262[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class262 var5 = var3[var4];
         if(this.field3630.containsKey(var5)) {
            var2.put(var5, this.field3630.get(var5));
         } else {
            Font var6 = Preferences.method1596(this.field3632, this.field3631, var5.field3623, "");
            if(var6 != null) {
               this.field3630.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "43"
   )
   public static String method4703(CharSequence var0) {
      return class25.method209('*', var0.length());
   }
}
