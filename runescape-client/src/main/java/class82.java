import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class82 {
   @ObfuscatedName("i")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("j")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("v")
   static int[] field1254;
   @ObfuscatedName("x")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("e")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("b")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1762218821
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lbm;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static IndexedSprite field1265;
   @ObfuscatedName("k")
   static Calendar field1261;
   @ObfuscatedName("t")
   static final String[] field1266;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -287459979
   )
   static int field1263;

   static {
      field1254 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1261 = Calendar.getInstance();
      field1266 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1263 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljy;",
      garbageValue = "956826945"
   )
   public static Overlay method1733(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgi;IB)V",
      garbageValue = "13"
   )
   static final void method1744(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class94.field1408 = 0;
      class31.method308(var0);

      for(int var3 = 0; var3 < class94.field1408; ++var3) {
         int var4 = class94.field1415[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 1) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         class44.method690(var0, var4, var5, var6);
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1108213957"
   )
   public static void method1724() {
      if(class245.field3316 != null) {
         class245.field3316.close();
      }

   }
}
