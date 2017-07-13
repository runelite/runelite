import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -12710693
   )
   int field1282;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 903686783
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 419083685
   )
   @Export("health")
   int health;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2012199393
   )
   int field1275;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1282 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1275 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1838857537"
   )
   void method1516(int var1, int var2, int var3, int var4) {
      this.field1282 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1275 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;B)V",
      garbageValue = "1"
   )
   public static void method1509(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3361 = var1;
      KitDefinition.field3352 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "826909945"
   )
   static String method1517(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-76"
   )
   static int method1513(int var0, Script var1, boolean var2) {
      Widget var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
      if(var0 == 2600) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.field2708;
         return 1;
      } else if(var0 == 2611) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.field2703;
         return 1;
      } else if(var0 == 2613) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = var3.field2683.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2082236980"
   )
   static final void method1515() {
      Client.secretPacketBuffer1.putOpcode(44);
      Client.secretPacketBuffer1.putByte(0);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "1379190305"
   )
   static int method1508(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1551()?(var1.method1551()?0:1):(var1.method1551()?-1:0)):(var2 == 5?(var0.method1520()?(var1.method1520()?0:1):(var1.method1520()?-1:0)):(var2 == 6?(var0.method1521()?(var1.method1521()?0:1):(var1.method1521()?-1:0)):(var2 == 7?(var0.method1561()?(var1.method1561()?0:1):(var1.method1561()?-1:0)):var0.id - var1.id)))));
      }
   }
}
