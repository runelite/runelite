import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public abstract class class297 implements Comparator {
   @ObfuscatedName("w")
   static int[] field3826;
   @ObfuscatedName("z")
   Comparator field3825;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "90"
   )
   final void method5388(Comparator var1) {
      if(this.field3825 == null) {
         this.field3825 = var1;
      } else if(this.field3825 instanceof class297) {
         ((class297)this.field3825).method5388(var1);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lkm;Lkm;I)I",
      garbageValue = "-250419645"
   )
   protected final int method5387(Nameable var1, Nameable var2) {
      return this.field3825 == null?0:this.field3825.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILjd;IB)V",
      garbageValue = "30"
   )
   static void method5394(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class80 var5 = new class80();
      var5.field1240 = var0;
      var5.field1241 = var1 * 128;
      var5.field1256 = var2 * 128;
      int var6 = var3.width;
      int var7 = var3.length;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.length;
         var7 = var3.width;
      }

      var5.field1243 = (var6 + var1) * 128;
      var5.field1246 = (var7 + var2) * 128;
      var5.field1244 = var3.ambientSoundId;
      var5.field1245 = var3.int4 * 128;
      var5.field1248 = var3.int5;
      var5.field1249 = var3.int6;
      var5.field1250 = var3.field3596;
      if(var3.impostorIds != null) {
         var5.field1242 = var3;
         var5.method1781();
      }

      class80.field1253.addFront(var5);
      if(var5.field1250 != null) {
         var5.field1251 = var5.field1248 + (int)(Math.random() * (double)(var5.field1249 - var5.field1248));
      }

   }
}
