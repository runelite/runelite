import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class265 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   public static IndexDataBase field3351;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   public static NodeCache field3352;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   IterableHashTable field3353;

   static {
      field3352 = new NodeCache(64);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120970672"
   )
   public void method4976() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-83961279"
   )
   public void method4990(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4978(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-132881650"
   )
   void method4978(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3353 = CacheFile.readStringIntParameters(var1, this.field3353);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1681148037"
   )
   public int method4982(int var1, int var2) {
      IterableHashTable var4 = this.field3353;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-188946533"
   )
   public String method4980(int var1, String var2) {
      return CombatInfoListHolder.method1822(this.field3353, var1, var2);
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(IIII)Lbe;",
      garbageValue = "-1188594297"
   )
   static final WidgetNode method4994(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class25.method465(var1);
      Widget var4 = OwnWorldComparator.getWidget(var0);
      DState.method3548(var4);
      if(Client.field756 != null) {
         DState.method3548(Client.field756);
         Client.field756 = null;
      }

      WorldComparator.method9();
      class45.method818(Widget.widgets[var0 >> 16], var4, false);
      GrandExchangeOffer.runWidgetOnLoadListener(var1);
      if(Client.widgetRoot != -1) {
         class76.method1849(Client.widgetRoot, 1);
      }

      return var3;
   }
}
