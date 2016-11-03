import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public abstract class class110 {
   @ObfuscatedName("u")
   static byte[][] field1936;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -645297731
   )
   public int field1937;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -180684627
   )
   public int field1938;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1860303927
   )
   public int field1939;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1314734553
   )
   public int field1941;
   @ObfuscatedName("bl")
   static ModIcon[] field1942;
   @ObfuscatedName("bn")
   static ModIcon[] field1944;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1042827329
   )
   static int field1945;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-1416017655"
   )
   public abstract boolean vmethod2444(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1682023712"
   )
   static final void method2445() {
      if(null != class178.field2948) {
         class178.field2948.method1217();
      }

      if(null != class141.field2184) {
         class141.field2184.method1217();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "940191869"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field903.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field916.method3305(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method797(new Buffer(var2));
         }

         var1.method802();
         NPCComposition.field903.put(var1, (long)var0);
         return var1;
      }
   }
}
