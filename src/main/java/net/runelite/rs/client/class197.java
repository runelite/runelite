package net.runelite.rs.client;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public final class class197 implements Iterable {
   @ObfuscatedName("j")
   int field3091;
   @ObfuscatedName("l")
   class207[] field3092;
   @ObfuscatedName("a")
   class207 field3093;

   @ObfuscatedName("l")
   public void method3760(class207 var1, long var2) {
      if(var1.field3110 != null) {
         var1.method3853();
      }

      class207 var4 = this.field3092[(int)(var2 & (long)(this.field3091 - 1))];
      var1.field3110 = var4.field3110;
      var1.field3111 = var4;
      var1.field3110.field3111 = var1;
      var1.field3111.field3110 = var1;
      var1.field3112 = var2;
   }

   @ObfuscatedName("j")
   public class207 method3761(long var1) {
      class207 var3 = this.field3092[(int)(var1 & (long)(this.field3091 - 1))];

      for(this.field3093 = var3.field3111; this.field3093 != var3; this.field3093 = this.field3093.field3111) {
         if(this.field3093.field3112 == var1) {
            class207 var4 = this.field3093;
            this.field3093 = this.field3093.field3111;
            return var4;
         }
      }

      this.field3093 = null;
      return null;
   }

   public class197(int var1) {
      this.field3091 = var1;
      this.field3092 = new class207[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class207 var3 = this.field3092[var2] = new class207();
         var3.field3111 = var3;
         var3.field3110 = var3;
      }

   }

   public Iterator iterator() {
      return new class193(this);
   }

   @ObfuscatedName("a")
   public void method3764() {
      for(int var1 = 0; var1 < this.field3091; ++var1) {
         class207 var2 = this.field3092[var1];

         while(true) {
            class207 var3 = var2.field3111;
            if(var3 == var2) {
               break;
            }

            var3.method3853();
         }
      }

      this.field3093 = null;
   }
}
