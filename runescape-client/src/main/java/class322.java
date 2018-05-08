import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
public class class322 implements Comparator {
   @ObfuscatedName("g")
   final boolean field3942;

   public class322(boolean var1) {
      this.field3942 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkg;Lkg;I)I",
      garbageValue = "-1666509587"
   )
   int method5758(Nameable var1, Nameable var2) {
      return this.field3942?var1.getRsName().compareCleanName(var2.getRsName()):var2.getRsName().compareCleanName(var1.getRsName());
   }

   public int compare(Object var1, Object var2) {
      return this.method5758((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lbx;Lbx;IZIZB)I",
      garbageValue = "77"
   )
   static int method5750(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = MouseRecorder.method1164(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = MouseRecorder.method1164(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
