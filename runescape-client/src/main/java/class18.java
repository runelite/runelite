import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class18 implements Comparator {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("item_ref")
   static IndexDataBase item_ref;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static BuildType field326;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lr;Lr;I)I",
      garbageValue = "483473830"
   )
   int method145(class14 var1, class14 var2) {
      return var1.method85().compareTo(var2.method85());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method145((class14)var1, (class14)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1228117423"
   )
   public static void method143() {
      MouseInput var0 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field733 = MouseInput.field731 * -1995837037;
         MouseInput.field734 = MouseInput.mouseX;
         MouseInput.field735 = MouseInput.mouseY;
         MouseInput.field740 = MouseInput.field726;
         MouseInput.field741 = MouseInput.field737;
         MouseInput.field742 = MouseInput.field738;
         MouseInput.field736 = MouseInput.field739;
         MouseInput.field726 = 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Liy;",
      garbageValue = "-36"
   )
   public static class244 method144(int var0) {
      class244 var1 = (class244)class244.field3304.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CollisionData.field2305.getConfigData(19, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4334(new Buffer(var2));
         }

         class244.field3304.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1826303356"
   )
   static int method142(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class43.field582:class208.field2580;
      if(var0 == 1600) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class84.intStack[++class84.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class84.intStack[++class84.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class84.intStack[++class84.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class84.intStack[++class84.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2681;
         return 1;
      } else if(var0 == 1611) {
         class84.intStack[++class84.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2675;
         return 1;
      } else if(var0 == 1613) {
         class84.intStack[++class84.intStackSize - 1] = var3.field2679.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
