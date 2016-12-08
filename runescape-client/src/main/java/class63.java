import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class63 implements Runnable {
   @ObfuscatedName("o")
   class103 field1088;
   @ObfuscatedName("dh")
   static byte[][] field1089;
   @ObfuscatedName("b")
   volatile boolean field1090 = false;
   @ObfuscatedName("g")
   volatile boolean field1091 = false;
   @ObfuscatedName("m")
   volatile class57[] field1092 = new class57[2];
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -899164823
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("u")
   static ModIcon[] field1094;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1410212941"
   )
   public static void method1143() {
      NPCComposition.field2995.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1245402582"
   )
   static final void method1145(int var0) {
      if(class2.method25(var0)) {
         Player.method234(Widget.widgets[var0], -1);
      }
   }

   public void run() {
      this.field1091 = true;

      try {
         while(!this.field1090) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class57 var2 = this.field1092[var1];
               if(var2 != null) {
                  var2.method1020();
               }
            }

            XClanMember.method237(10L);
            CombatInfo1.method594(this.field1088, (Object)null);
         }
      } catch (Exception var7) {
         FaceNormal.method1844((String)null, var7);
      } finally {
         this.field1091 = false;
      }

   }
}
