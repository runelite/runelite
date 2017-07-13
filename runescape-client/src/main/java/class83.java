import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class83 {
   @ObfuscatedName("v")
   static int[] field1331;
   @ObfuscatedName("e")
   @Export("SHAPE_VERTICIES")
   static int[][] SHAPE_VERTICIES;
   @ObfuscatedName("l")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("w")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 684838637
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("u")
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("t")
   static Calendar field1337;
   @ObfuscatedName("c")
   static final String[] field1326;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1701060465
   )
   static int field1334;
   @ObfuscatedName("o")
   static class47 field1330;
   @ObfuscatedName("n")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("r")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("k")
   static Widget field1336;

   static {
      field1331 = new int[5];
      SHAPE_VERTICIES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1337 = Calendar.getInstance();
      field1326 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1334 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1194575923"
   )
   public static int method1641(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1986557717"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FrameMap.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4547(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4530(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3542 != -1) {
            var1.method4505(getItemDefinition(var1.field3542), getItemDefinition(var1.field3492));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3538 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3536 = 0;
            if(var1.field3541 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3541.method3484(); var4 != null; var4 = var1.field3541.method3485()) {
                  class251 var5 = class228.method4068((int)var4.hash);
                  if(var5.field3389) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3541 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "2024212929"
   )
   public static Object method1617(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2412) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2412 = true;
            }
         }

         return var0;
      }
   }
}
