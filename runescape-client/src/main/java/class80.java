import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public final class class80 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   static Deque field1324;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1898547939
   )
   int field1318;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   ObjectComposition field1325;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1828789211
   )
   int field1317;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -994524271
   )
   int field1320;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1650915707
   )
   int field1321;
   @ObfuscatedName("i")
   int[] field1322;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   class115 field1313;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -579929655
   )
   int field1319;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2097579917
   )
   int field1311;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -761071171
   )
   int field1316;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1370126447
   )
   int field1326;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1074260825
   )
   int field1312;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   class115 field1315;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 824894305
   )
   int field1323;

   static {
      field1324 = new Deque();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1536209892"
   )
   void method1657() {
      int var1 = this.field1318;
      ObjectComposition var2 = this.field1325.getImpostor();
      if(var2 != null) {
         this.field1318 = var2.ambientSoundId;
         this.field1317 = var2.field3483 * 128;
         this.field1320 = var2.field3445;
         this.field1321 = var2.field3470;
         this.field1322 = var2.field3486;
      } else {
         this.field1318 = -1;
         this.field1317 = 0;
         this.field1320 = 0;
         this.field1321 = 0;
         this.field1322 = null;
      }

      if(var1 != this.field1318 && this.field1313 != null) {
         CombatInfoListHolder.field1364.method1949(this.field1313);
         this.field1313 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1955673515"
   )
   static String method1662() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class96.field1508.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}
