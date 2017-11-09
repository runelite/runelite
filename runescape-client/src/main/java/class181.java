import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class181 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -37747781
   )
   static int field2502;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -633177205
   )
   static int field2503;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1598327787
   )
   static int field2504;
   @ObfuscatedName("j")
   static byte[][] field2505;
   @ObfuscatedName("v")
   static byte[][] field2506;
   @ObfuscatedName("x")
   static byte[][] field2507;

   static {
      field2502 = 0;
      field2503 = 0;
      field2504 = 0;
      field2505 = new byte[1000][];
      field2506 = new byte[250][];
      field2507 = new byte[50][];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "-870838298"
   )
   static synchronized byte[] method3513(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2502 > 0) {
         var2 = field2505[--field2502];
         field2505[field2502] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2503 > 0) {
         var2 = field2506[--field2503];
         field2506[field2503] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2504 > 0) {
         var2 = field2507[--field2504];
         field2507[field2504] = null;
         return var2;
      }

      if(AbstractByteBuffer.field2513 != null) {
         for(int var4 = 0; var4 < BuildType.field3245.length; ++var4) {
            if(BuildType.field3245[var4] != var0) {
               if(var0 < BuildType.field3245[var4]) {
                  ;
               }
            } else if(FaceNormal.field2051[var4] > 0) {
               byte[] var3 = AbstractByteBuffer.field2513[var4][--FaceNormal.field2051[var4]];
               AbstractByteBuffer.field2513[var4][FaceNormal.field2051[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-485669562"
   )
   public static void method3515() {
      class259.field3448.reset();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lik;II)Lko;",
      garbageValue = "-788334787"
   )
   public static IndexedSprite method3516(IndexDataBase var0, int var1) {
      byte[] var3 = var0.method4375(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         DecorativeObject.decodeSprite(var3);
         var2 = true;
      }

      return !var2?null:class34.method511();
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1283984817"
   )
   static final void method3514() {
      Client.field952.method1970();
      World.method1669();
      class56.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class37.method552(2);
      Client.field1026 = -1;
      Client.field1088 = false;
      CombatInfo2.method4592();
      class287.setGameState(10);
   }
}
