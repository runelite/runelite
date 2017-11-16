import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class86 {
   @ObfuscatedName("x")
   static final BigInteger field1290;
   @ObfuscatedName("f")
   static final BigInteger field1293;
   @ObfuscatedName("aq")
   static int[] field1295;

   static {
      field1290 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1293 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1524711780"
   )
   static int method1669(int var0, Script var1, boolean var2) {
      Widget var3 = class64.method1017(class82.intStack[--class82.intStackSize]);
      if(var0 == 2500) {
         class82.intStack[++class82.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class82.intStack[++class82.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class82.intStack[++class82.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class82.intStack[++class82.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class82.intStack[++class82.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class82.intStack[++class82.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1655804454"
   )
   static final void method1670(int var0, int var1, int var2, boolean var3) {
      if(class64.loadWidget(var0)) {
         Widget.method4066(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }
}
